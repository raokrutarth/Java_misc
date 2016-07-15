import junit.framework.TestCase;

public class Customertest extends TestCase 
{
    
    public void testcompare() 
    {
        Camera camOne = new Camera(true, false , true, "Used", 158.2, 3);
        Camera camTwo = new Camera(true, false , true, "Used", 158.2, 3);
        
        Customer cust = new Customer();
        //int choice = 99;
        int choice = cust.compare(camOne, camTwo);
        
        assertEquals(0, choice);       
    }
    
}
