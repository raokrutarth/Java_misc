import junit.framework.TestCase;

public class Cameratest extends TestCase 
{    
    public void testcomputeValue() 
    {
        Camera camOne = new Camera(false , false, false, "Refurbished", 225.00, 3);
        Camera camTwo = new Camera(false, true, false, "New", 225.00, 3);
        int val1 = camOne.computeValue();        
        int val2 = camTwo.computeValue();
        
        assertEquals(1, val1);
        assertEquals(3, val2);
    }
    
}
