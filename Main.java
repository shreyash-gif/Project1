import java.io.*;
import java.util.*;

  interface IIITN 
{
    
    
   public String toString();
    

}
class Student implements IIITN
{ 
    String name;
    String ID;
    int year;
    int sem;

    
    public String toString(String name,String ID, int year, int sem)
    {
        this.name=name;
        this.ID=ID;
        this.year = year;
        this.sem = sem;
        
        return("Your name is " + name + "Your ID is " + ID + "\n" + "Your Year is " + year + "Your Sem is " + sem);
    }
}
class BrilliantStudents extends Student
{
   int CGPA;
   String Grade ;
   
   public String Display(String name,String ID, int year, int sem,int CGPA,String Grade)
   {
    super(name,ID,year,sem);
    this.CGPA = CGPA;
    this.Grade = Grade;
    System.out.println(super.toString() + "Your CGPA is " + CGPA + "Your Grade is " + Grade);
   }

}
class Topper extends BrilliantStudents
{
    String How;
    
    @Override
    public String Display(String name,String ID, int year, int sem,int CGPA,String Grade,String How)
    {
        super(name,ID,year,sem,CGPA,Grade);
        this.How = How;
        System.out.println(super.Display() + "\n" + "How do you Study for your Exam?" + How);
    }
    
}
public class Main {
    public static void main ( String[] args )
    )
    {
        BrilliantStudent s1 = new BrilliantStudent();
        Topper s2 = new Topper();
        System.out.println(s1.toString("Shreyash","BT21CSE105",2, 3) );
        System.out.println(s2.Display(9.9,"A","I Study very Smartly by Enjoying It") );
    }
} 