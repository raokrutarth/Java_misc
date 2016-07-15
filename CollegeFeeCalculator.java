import javax.swing.JOptionPane;
public class CollegeFeeCalculator
{
    public static void main(String[] args)
    {
        int repeat = 0;
        do
        {
            JOptionPane.showMessageDialog (null, "Welcome to CollegeFeeCalculator!",
                                           "CollegeFeeCalculator", JOptionPane.INFORMATION_MESSAGE);
            String name = JOptionPane.showInputDialog(null, "Please enter your name, then press OK", "Name",
                                                      JOptionPane.QUESTION_MESSAGE);
            String[] options = {"Full-Time", "Part-Time"};
            int enrollment = JOptionPane.showOptionDialog(null, "Please select your enrollment", "Enrollment",
                                                          JOptionPane.YES_NO_OPTION,  JOptionPane.QUESTION_MESSAGE,
                                                          null, options, null );
            
            String creditHours = null;
            do
            {
                creditHours = JOptionPane.showInputDialog(null, "Please enter the no. of credit hours, then press OK",
                                                          "Credit Hours", JOptionPane.QUESTION_MESSAGE); 
                if ( !isCorrectCredit( creditHours ) )
                {
                    JOptionPane.showMessageDialog(null, "Please enter valid credit hours for the current enrollment",
                                                  "Invalid no. of credits", JOptionPane.ERROR_MESSAGE);
                }
            }
            while ( !isCorrectCredit( creditHours ) );
            
            String[] ress = { "In-state","Out-of-state","International" };
            Object res = JOptionPane.showInputDialog(null, "Please select the appropriate residency",
                                                     "Residency", JOptionPane.QUESTION_MESSAGE,
                                                     null, ress, null);
            String residence = (String) res;
            
            String[] housingOptions = { "ON-Campus","OFF-Campus" };
            Object housing = JOptionPane.showInputDialog(null, "Please select your housing",
                                                         "Housing", JOptionPane.QUESTION_MESSAGE,
                                                         null, housingOptions, null);
            String actualHousing = (String) housing;
            
            String[] dormOptions = { "Earhart","Hillenbrand","Owen","Windsor"};
            Object dorm = JOptionPane.showInputDialog(null, "Please select the residence hall",
                                                      "Residence-Hall", JOptionPane.QUESTION_MESSAGE,
                                                      null, dormOptions, null);
            String actualDorm = (String) dorm;
            
            
            //System.out.printf("name: %s\n enrollment: %d\n creditHours: %s\n residence: %s\n actualHousing: %s\n actualDorm: %s\n",
            //name, enrollment, creditHours,  residence, actualHousing, actualDorm );
        
        String fee = calculateFee( name, enrollment, creditHours,  residence, actualHousing, actualDorm);
        
        String finalMessage = "name: " + name+ "\n" + "enrollment: " + enrollment+ "\n" +
            "creditHours: " + creditHours+"\n"+ "residence: " + "residence" + "\n" +
            "actualHousing: " + actualHousing + "\n" + "actualDorm: " + actualDorm + "\n" 
            + "Total fee: " + fee ;
        JOptionPane.showMessageDialog (null, finalMessage,
                                       "CollegeFeeCalculator Summary", JOptionPane.INFORMATION_MESSAGE);
        repeat = JOptionPane.showConfirmDialog(null,
                                               "Would you like to perform another fee calculation?",
                                               "Are you done?",
                                               JOptionPane.YES_NO_OPTION);
        }
         while (repeat == 0);                         
        
        }
    
    
    
    public static String calculateFee (String name, int enrollment, String creditHours, 
                                       String residence, String actualHousing,String actualDorm )
    {
        return "$5000"; //calculate. method returns a test purpose value.
    }
    
    public static boolean isCorrectCredit(String credit)
    {
        if (credit != null)
        {
            int creditn = Integer.parseInt(credit);
            return (creditn <= 20 && creditn >= 0);
        }
        else
        { 
            return false;
        }
        
    }
    }