import java.io.*;
import java.util.*;

import javax.xml.stream.events.StartDocument;

public class OrderView 
{
    void displaydishes(){
 System.out.println("    Welcome To Hawala Restaurant \n");
 System.out.println( "You can't buy happiness, but you can buy food, and that's kind of the same thing.\n");
    }

}
 class Starter extends OrderView
{
    @Override
    void displaydishes(){
    System.out.println("Veg Chill Cripsy             70Rs\n");
    System.out.println("Veg Spring Roll              80Rs\n");
    System.out.println("Masala Papad                 30Rs\n");
    System.out.println("Momos                        40Rs\n");
    System.out.println("Aloo Cheese Crequettes       50Rs\n");
    }
    //void getorder();
     public static void main(String[] args) {
        Starter c1 = new Starter() ;
        c1.displaydishes();
            
        
        
    }

}
/*interface Mexican implements OrderView
{

}
interface Chinese implements OrderView
{

}
interface Italian implements OrderView
{

}
interface SouthIndian implements OrderView
{

}
interface NorthIndian implements OrderView
{

}
interface Soft Drinks and Shakes implements OrderView
{

}
class Ender implements Starter , Mexican , Chinese , Italian , SouthIndian , NorthIndian , Soft Drinks and Shakes
{

}

*/
