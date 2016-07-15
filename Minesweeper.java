import java.util.Random;
import java.util.Scanner;

public class Minesweeper
{
    private boolean[][] minefield;
    private int[][] clueGrid ;
    private boolean[][] checked;
    public Minesweeper(int rows, int columns, int mines)
    {
        minefield = new boolean[rows][columns];
        clueGrid = new int[rows][columns];
        checked = new boolean[rows][columns];
        generateMinefield(mines);
        generateClueGrid();
        
        for (int i = 0; i < checked.length; i++)
        {
            for (int j = 0; j < checked[i].length; j++)
            {
                checked[i][j] = false;
            }      
        }
    }
    private void generateMinefield(int mines) //int mines, boolean[][] minefield
    {
        for (int i = 0; i < minefield.length; i++)
        {
            for (int j = 0; j < minefield[i].length; j++)
            {
                checked[i][j] = false;
            }      
        }
        
        Random random = new Random();        
        int counter =0;
        int mines_placed = 0;
        while (counter < mines)
        {
            int random_row = random.nextInt(minefield.length);
            int random_cloumn = random.nextInt(minefield[0].length);
            if (minefield[random_row][random_cloumn] == true)
            {
                continue;
            }
            else
            {
                minefield[random_row][random_cloumn] = true; 
            }
            counter++;
            mines_placed++;
        }
    }
    // i = row index, j = column index
    // minefield.length = number of rows, minefield[0].length = number of columns
    public int CountingMines(int row_index, int column_index)
    {
        int mine_count = 0;
        for (int r = Math.max(row_index-1,0); r <= Math.min(row_index+1,minefield.length-1); r++)
        {
            for (int c = Math.max(column_index-1,0); c <= Math.min(column_index+1,minefield[0].length-1); c++)
            {
                if (!(r == row_index && c == column_index)) 
                {
                    if(minefield[r][c] == true)
                    {
                        mine_count = mine_count + 1;
                    }
                }
            }  
        }
        return mine_count; // mine_count = number of mines placed after for loop executes. Testing feature.
    }   
    
    
    private void generateClueGrid() 
    {
        for (int i = 0; i < clueGrid.length; i++)
        {
            for (int j = 0; j < clueGrid[i].length; j++)
            {
                if (minefield[i][j] == true) // Checking if there is a mine in given position.
                {
                    clueGrid[i][j] = -1;
                }
                else
                {
                    clueGrid[i][j] = CountingMines(i , j); // Counting the mines around the cell which is at position [i][j] in the matrix.
                }
            }      
        }
    }
    private void printBoard() 
    {
        System.out.print("   "); 
        for (int j = 0; j < minefield[0].length; j++) 
            System.out.print(" " + (j+1));
        System.out.println();
        System.out.print("  +-"); 
        for (int j = 0; j < minefield[0].length; j++) 
            System.out.print("--");
        System.out.println(); 
        
        char row_letter = 'A';
        for (int i = 0; i < minefield.length; i++) 
        {
            
            System.out.print(row_letter + " |"); 
            for (int j = 0; j < minefield[0].length; j++) 
            { 
                char cell_symbol;
                if (!checked[i][j]) 
                    cell_symbol = '?';
                else if (minefield[i][j]) 
                    cell_symbol = '*';
                else if (clueGrid[i][j] > 0) 
                    cell_symbol = (char)('0' + clueGrid[i][j]);
                else  // defensive condition if cell is not a clue or mine.
                    cell_symbol = ' ';
                System.out.print(" " + cell_symbol);
            }
            System.out.println();
            row_letter++;
        }
    }
    public void start() 
    {
        Scanner in = new Scanner(System.in);
        boolean win = false; 
        while (win == false) 
        {
            printBoard();
            System.out.print("Check cell? ");
            String line = in.nextLine().toUpperCase();
            int row = line.charAt(0)-'A';
            int column = line.charAt(1)-'1';
             if (minefield[row][column] == true)
             {
                 break; // end game with a loss when a mine cell is selected.
             }                
            else 
            {
               checked[row][column] = true; 
            }               
            win = true;
            for (int i = 0 ; i < minefield.length && win; i++)
                for (int j = 0; j < minefield[0].length && win; j++)
                if (!checked[i][j] && !minefield[i][j])
                win = false;
        }
        // game is over
        in.close(); 
        for (int i = 0 ; i < minefield.length; i++)
            for (int j = 0; j < minefield[0].length; j++)
            checked[i][j] = true;
        
        printBoard();
        if (win)
            System.out.println("\nYou win!");
        else
            System.out.println("\nYou lost. Try again.");
    }
    public static void main(String[] args)
    {
        Minesweeper m = new Minesweeper(5, 5, 15);
        m.start();
    }
}