import java.util.Scanner;

public class MyCLIParser 
{
    public static void main(String[] args) 
    {
        // if no arguments, print help and return
        if (args.length == 0 || args == null) 
        {
            help(args);
            return;
        }
        //-help
        else if (args[0].equals("-help"))  
            help(args);
        //-add
        else if (args[0].equals("-add"))   
            add(args);
        //-sub
        else if (args[0].equals("-sub"))   
            sub(args);
        //-mul
        else if (args[0].equals("-mul"))   
            mul(args);
        //-div
        else if (args[0].equals("-div"))   
            div(args);
        //-stats
        else if (args[0].equals("-stats")) 
            stats(args);
        //-table
        else if (args[0].equals("-seq")) seq(args);
    }
    
    public static boolean isInteger(String s) 
    {
        Scanner in = new Scanner(s);
        if (in.hasNextInt())
        {
            return true;
        }
        return false;
    }
    
    private static void help(String[] args) 
    {
        System.out.println("-add: The add command will take one or more integer arguments. " +
                           "Then it will add up all the integers modulo 97 and print the value.");
        System.out.println("-sub: The sub command will take two integer arguments." +
                               " Then it will subtract the second integer from the first integer and print the value.");
        System.out.println("-div: The div command will take two integer arguments. Then it will do the Euclidean " +
                           "division of the first integer by the second integer and print the quotient and" +
                               " remainder on separate lines.");
        System.out.println("-stats: The stats command will take one or more integer arguments. " +
                               "Then it will find and print out total, maximum, minimum, average values, " +
                               "in that order and each on a separate line.");
        System.out.println("-seq: The seq command will take two integer value arguments. " +
                               "It will generate an arithmetic sequence table of ten elements. " +
                               "The first argument is the initial value, " + 
                           "the second value is the common difference between to consecutive terms");        
    }
    
    private static void add(String[] args) 
    {
        boolean isCorrectFormat = true;
        if (args.length == 1)
        {
            System.out.println("Error: Argument count mismatch");
            isCorrectFormat = false;
        }
        
        
        for (int i = 1; i < args.length; i++)
        {
            if (isInteger(args[i]) == false)
            {
                System.out.println("Error: Argument type mismatch");
                isCorrectFormat = false;
                break;                
            }
        }
        
        if (isCorrectFormat)
        {
            int sum = 0;
            for (int i = 1; i < args.length; i++)
            {
                sum = sum + Integer.parseInt(args[i]); 
            }
            int result = sum % 97;
            System.out.println(result);
        }
    }
    
    private static void sub(String[] args) 
    {   
        if ( args.length != 3)
        {
            System.out.println("Error: Argument count mismatch");
        }                
        else if (!(isInteger(args[1]) && isInteger(args[2])))
        {
            System.out.println("Error: Argument type mismatch");
        }  
        else
        {
            int result = Integer.parseInt(args[1]) - Integer.parseInt(args[2]);
            System.out.println(result);                
        }
    }
    
    private static void mul(String[] args) 
    {
        boolean isCorrectFormat = true;
        if (args.length == 1)
        {
            System.out.println("Error: Argument count mismatch");
            isCorrectFormat = false;
        }       
        for (int i = 1; i < args.length; i++)
        {
            if (isInteger(args[i]) == false)
            {
                System.out.println("Error: Argument type mismatch");
                isCorrectFormat = false;
                break;
                
            }
        }        
        if (isCorrectFormat)
        {
            int product = 1;
            for (int i = 1; i < args.length; i++)
            {                
                product = product * Integer.parseInt(args[i]); 
            }
            int result = product % 97;
            System.out.println(result);
        }       
    }
    
    private static void div(String[] args) 
    {
        if ( args.length != 3)
        {
            System.out.println("Error: Argument count mismatch");
        }                
        else if (!(isInteger(args[1]) && isInteger(args[2])))
        {
            System.out.println("Error: Argument type mismatch");
        }
        else if (Integer.parseInt(args[2]) == 0)
        {
            System.out.println("Undefined");
        }
        else
        {
            int quotient = Integer.parseInt(args[1]) / Integer.parseInt(args[2]);
            int remainder = Integer.parseInt(args[1]) % Integer.parseInt(args[2]);
            System.out.println("Quotient " + quotient);
            System.out.println("Remainder " + remainder);
        }
    }
    
    private static void stats(String[] args) 
    {
        boolean isCorrectFormat = true;
        if (args.length == 1)
        {
            System.out.println("Error: Argument count mismatch");
            isCorrectFormat = false;
        }       
        for (int i = 1; i < args.length; i++)
        {
            if (isInteger(args[i]) == false)
            {
                System.out.println("Error: Argument type mismatch");
                isCorrectFormat = false;
                break;
                
            }
        }        
        if (isCorrectFormat)
        {
            int sum = 0;
            int count = 0;
            int min = Integer.parseInt(args[1]);
            int max = Integer.parseInt(args[1]);
            
            for (int i = 1; i < args.length; i++)
            {
                sum = sum + Integer.parseInt(args[i]);
                count = count + 1;
                if (Integer.parseInt(args[i]) > max)
                {
                    max = Integer.parseInt(args[i]);
                }
                if (Integer.parseInt(args[i]) < min)
                {
                    min = Integer.parseInt(args[i]); 
                }
            }
            double avg = (double)sum / count;
            System.out.println("Total " + sum);
            System.out.println("Max " + max);
            System.out.println("Min " + min);
            System.out.printf("Average %.2f\n", avg);
        }
    }
    
    private static void seq(String[] args) 
    {
        if ( args.length != 3)
        {
            System.out.println("Error: Argument count mismatch");
        }                
        else if (!(isInteger(args[1]) && isInteger(args[2])))
        {
            System.out.println("Error: Argument type mismatch");
        }
        else if (Integer.parseInt(args[2]) == 0)
        {
            System.out.println("Undefined");
        }
        else
        {
            int lower = Integer.parseInt(args[1]);
            int commonDiff = Integer.parseInt(args[2]);           
            int count = 0;
            for (int i = lower; count < 10 ; i += commonDiff)
            {
                System.out.print(i + " ");
                count++;
            }
            
        }
    }
}
