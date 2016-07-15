import java.util.*;
/**
 * CS 180 - Lab 05 - Repetition
 * 
 * (Brief description of the class file)
 * 
 * @author (Krutarth Rao) raok@purdue.edu
 * 
 * @lab (LM3)
 *
 * @version (10/Feb)
 */
public class Repetition
{
    public static void main(String[] args)
    {
        even();
        System.out.println(); 
        powers();
        System.out.println();
        alphabet();
        System.out.println();
        vertical("abcde");
        testResults();
        reverse();
        sqrAndCube();
        
    }
    public static void even()
    {
        for (int i = 0; i < 101; i++)
        {
            if (i%2 == 0)
            {System.out.print(i + " "); }
        }
    }
    public static void powers()
    {
        int num = 0;
        double answer = 0;
        while(answer < 1000)
        {
            answer = Math.pow(2, num);
            System.out.print(answer + " ");
            num++;
        }
    }
    public static void alphabet()
    {       
          
          for (char a = 'a'; a < 'z'+ 1; a++)
        {
            System.out.print(a);
        }
    }
    public static void vertical(String str)
    {
        for (int i = 0; i < str.length(); i++)
        {
            System.out.println(str.charAt(i));
        }
    }
    public static void testResults()
    {
       int[] numbers = new int[10000000];
       Scanner in = new Scanner(System.in);
       int i;
       for (i = 0; (in.hasNextInt()); i++)
           
         {
                int val = in.nextInt();
                numbers[i] = val;
         }       
       int sum = 0;
       int count = 0;
       int min = numbers[0];
       int max = numbers[0];
       for (int j = 0; j < i; j++)
       {
           sum = sum + numbers[j];
           count = count + 1;
           if (numbers[j] < min)
           {
               min = numbers[j];
           }
           else if (numbers[j] > max)
           {
               max = numbers[j];
           }
       }
       System.out.println("=====-----=====-----=====-----=====");
       System.out.println("=              Test Results       =");
       System.out.println("= Average:                  " + (sum/count));
       System.out.println("= Lowest:                   " + min);
       System.out.println("= Highest:                  " + max);
       System.out.println("====-----=====-----=====-----=====");      
        
    }
    public static void reverse()
    {
        Scanner in = new Scanner(System.in);
        System.out.println("Enter an integer please:");
        int input = in.nextInt();
        String a = input + "";
        
        for (int i = a.length()-1; i >= 0 ; i--)
        {
            System.out.print(a.charAt(i)) ;            
        }                                       
        
    } 
    public static void sqrAndCube()
    {
        for (int i = 1; i < 25001; i++)
        {
            double a = Math.pow(i, 6);
            if ( a < 25000)
            {
                System.out.println(a  + " is the cube of " +  Math.pow(i,2)  + 
                                   " and the square of " + Math.pow(i,3) );
            }
        }
    }
    
}








