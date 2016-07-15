import java.util.Scanner;
/**
 * CS180 - Lab 02
 * Finds the hypotenuse given two sides
 * @author Krutarth Rao, raok@purdue.edu
 **/

    
public class Pythagoras {
    
    public static void main(String[] args) {
        Pythagoras p = new Pythagoras(); //constructor
        Scanner scanner = new Scanner(System.in); //creating scanner
        System.out.print("Enter side 'a': "); //asking for input a
        int a = scanner.nextInt(); // assigning value to a
        System.out.print("Enter side 'b': "); // asking for input b
        int b = scanner.nextInt(); // assigning value to b
        double h = p.getHypotenuse(a, b); //calculating the hyp.
        System.out.printf("Hypotenuse: %.1f \n", h); // printing answer
        scanner.close(); //closing scanner
        
        
    
    }
    public double getHypotenuse(int a, int b) {
        double result; //declaring vlaue type
        result = Math.sqrt(a * a + b * b); //calculation
        return result; //returning the result
    }
}

