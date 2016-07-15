import java.util.*;
/**
 * CS180 - Lab 04 - Student
 *
 * (A student class to implement grading)
 *
 * @author (Krutarth Rao) raok@purdue.edu
 *
 * @lab (lm3)
 *
 * @version (2nd/feb)
 */
public class Student
{
    private String id;
    private String dept;
    private int part;
    private int abs;
    private int exam;
    
    public Student(String id, String dept, int abs, int exam, int part)
    {
      this.id = id;       // initialize this student's ID
      this.dept = dept;     // initialize this students department
      this.part = part;     // initialize this students participation
      this.abs = abs;     // initialize this students absences
      this.exam = exam; // exam
    }
   
   
    public int getOverallScore()
   {
       int totalScore;
       int attendanceScore = 0;
       if (this.abs == 0) 
       {
           attendanceScore = 2;
       }
       else if ( 1 <= this.abs && this.abs <= 4)
       {
           attendanceScore = 0;
       }
       else if (this.abs >= 5) ;
       {
           totalScore = 0;
       }
       totalScore = this.exam + this.part + attendanceScore;
       return totalScore;
       
   }
   public String getLetterGrade(int score)   
   {
       String letterGrade = "";
       if (this.abs >= 5)
       {
           letterGrade = "F";
       } 
       else if (score >= 95 && score <= 100)
       {
           letterGrade = "A+";
       }
       else if (90 <= score && score < 95) 
       {
           letterGrade = "A";
       }
       else if (80 <= score && score < 90) 
       {
           letterGrade = "B";
       }
       else if (70 <= score && score < 80) 
       {
           letterGrade = "C";
       }
       else if (60 <= score && score < 70) 
       {
           letterGrade = "D";
       }
       else if (score < 60) 
       {
           letterGrade = "F";
       }
       return letterGrade;          
   }
   
   
   public boolean hasPassedCourse(String grade)
   {
       if ( (grade.equals("A+") ||  grade.equals("A") || grade.equals("B") || grade.equals("C")
               || grade.equals("D")) && this.dept.equals("CS"))
       {
           return true;
       }
       else if (this.dept.equals("PH") && (grade.equals("A+") ||  grade.equals("A") || grade.equals("B")))
       {
           return true;
       }
       else
       {
           return false;
       }
   }
   public static void main(String[] args)
   {
       Student s = new Student("1020101" , "CS", 4, 59, 5);
       int totalScore = s.getOverallScore();
       String grade = s.getLetterGrade(totalScore);
       boolean result = s.hasPassedCourse(grade);
       
       System.out.println(s.id);
       System.out.println("Score: " + totalScore);
       System.out.println("Grade: " + grade);
       
       if (result == true)
       {
           System.out.println("Student "+ s.id +" has passed the course");
       }
          
       else
       {
           System.out.println("Student "+ s.id +" has failed the course");
       }      
   }      
}









