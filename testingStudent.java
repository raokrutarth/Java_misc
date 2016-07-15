import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class testingStudent extends TestCase {
    
    /**
     * A test method.
     * (Replace "X" with a name describing the test.  You may write as
     * many "testSomething" methods in this class as you wish, and each
     * one will be called when running JUnit over this class.)
     */
    public void testhasPassedCourse() 
    {
        Student s = new Student("1020101", "PH", 4, 75, 5);
        boolean pass = s.hasPassedCourse("B");
        assertEquals(true, pass);       
            
    }
    public void testgetOverallScore()
    {
        Student s = new Student("1020101", "PH", 4, 75, 5);
        int score = s.getOverallScore();
        assertEquals(80, score);
    }
    public void testgetLetterGrade()
    {
        Student s = new Student("1020101", "PH", 4, 75, 5);
        String grade = s.getLetterGrade(80);
        assertEquals(grade, "B");      
            
    }
    
}
