import java.util.*;

public class Customer
{
    public int compare(Camera camOne, Camera camTwo) 
    {
        int camChoice = -1;
        int valueOne = camOne.computeValue();
        int valueTwo = camTwo.computeValue();
        double priceOne = camOne.price;
        double priceTwo = camTwo.price;
        int ratingOne = camOne.userRating;
        int ratingTwo = camTwo.userRating;
        
        if (valueOne == valueTwo && ratingOne == ratingTwo  && Math.abs(priceOne - priceTwo) < 0.01 )
        {
            camChoice = 0;
        }
        else if ( Math.abs(priceOne - priceTwo) < 0.01 && ratingOne == ratingTwo )
        {
            if (valueOne > valueTwo)
            {
                camChoice = 1;
            }
            if (valueOne < valueTwo)
            {
                camChoice = 2;
            }
        }
        else if (valueOne == valueTwo && Math.abs(priceOne - priceTwo) < 0.01 )
        {
            if (ratingOne > ratingTwo)
            {
                camChoice = 1;
            }
            if (ratingOne < ratingTwo)
            {
                camChoice = 2;
            } 
        }
        else if (valueOne == valueTwo && ratingOne == ratingTwo)
        {
            if (priceTwo > priceOne)
            {
                camChoice = 1;
            }
            if (priceTwo < priceOne)
            {
                camChoice = 2;
            }
        }
        if ( camChoice == -1 )
        {
            double ratioOne = 0.0;
            double ratioTwo = 0.0;
            ratioOne = (priceOne / valueOne);
            ratioTwo = (priceTwo / valueTwo);
            if (ratioOne < ratioTwo && valueOne != 0 && valueTwo != 0)
            {
                camChoice = 1 ;
            }
            else if (ratioOne > ratioTwo && valueTwo != 0 && valueOne != 0)
            {
                camChoice = 2 ;
            }
            else if (Math.abs(ratioOne - ratioTwo) < 0.001)
            {
                camChoice = 0;
            }
            
        }
        
        return camChoice;        
    }
    public static void main(String[] args)
    {
        Scanner in = new Scanner(System.in);
        
        System.out.println("Enter attributes of Camera 1: ");
        System.out.println("Is WiFi enabled? (true/false)");
        boolean c1WiFi = in.nextBoolean();
        System.out.println("Is water resistant? (true/false)");
        boolean c1Water = in.nextBoolean();
        System.out.println("Is GPS enabled? (true/false)");
        boolean c1GPS = in.nextBoolean();
        in.nextLine();
        System.out.println("Condition? (New/Refurbished/Used)");
        String c1Condt = in.nextLine();
        System.out.println("Enter price in $ (0.00 to 1000.00)");
        double c1Price = in.nextDouble();
        System.out.println("Enter user rating (0 to 5)");
        int c1Rating = in.nextInt();
        
        System.out.println("============================");
        
        System.out.println("Enter attributes of Camera 2: ");
        System.out.println("Is WiFi enabled? (true/false)");
        boolean c2WiFi = in.nextBoolean();
        System.out.println("Is water resistant? (true/false)");
        boolean c2Water = in.nextBoolean();
        System.out.println("Is GPS enabled? (true/false)");
        boolean c2GPS = in.nextBoolean();
        in.nextLine();
        System.out.println("Condition? (New/Refurbished/Used)");
        String c2Condt = in.nextLine();
        System.out.println("Enter price in $ (0.00 to 1000.00)");
        double c2Price = in.nextDouble();
        System.out.println("Enter user rating (0 to 5)");
        int c2Rating = in.nextInt();
        
        Camera camOne = new Camera(c1WiFi, c1Water, c1GPS,
                                   c1Condt, c1Price, c1Rating);
        Camera camTwo = new Camera(c2WiFi, c2Water, c2GPS,
                                   c2Condt, c2Price, c2Rating);
        Customer cust = new Customer();        
        int choice = cust.compare(camOne, camTwo);
        
        System.out.println("======================");
        System.out.println("Result of Comparison: ");
        if (choice == 1)
        {
            System.out.println("Camera 1 is better than Camera 2");
        }
        else if (choice == 2)
        {
            System.out.println("Camera 2 is better than Camera 1");
        }
        
    }
}