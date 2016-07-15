import java.util.*;
/**
 * CS180 - Lab 03 - StringManipulator
 * 
 * gives out purdue email
 * 
 * @author (Krutarth) raok@purdue.edu
 * 
 * @lab (LM3)
 *
 * @date (22/Jan)
 */
public class StringManipulator 
{
    public String makeUserName(String fullName) 
    {
        String lowered = fullName.toLowerCase();
        int spc = lowered.indexOf(' ') + 1;
        String username = lowered.charAt(0) + lowered.substring(spc);
        return username;        
       
    }
    public String makeEmail(String userName, String domain)
    {
       String  lwrd = domain.toLowerCase();
       String email_id = userName + "@" + lwrd;
       return email_id;
    }
    public static void main(String[] args) 
    {
        StringManipulator sm = new StringManipulator();
        System.out.println("Enter fullname in format 'firstname lastname'");
        Scanner in = new Scanner(System.in);
        String input_name = in.nextLine();
        System.out.println("Enter domain");        
        String domain = in.nextLine();
        in.close();
        String urs = sm.makeUserName(input_name);
        System.out.println("The username is: " + urs );
        String eml = sm.makeEmail(sm.makeUserName(input_name) , domain);
        System.out.println("Te email iD for the person is: " + eml );
                   
    }    
        
}