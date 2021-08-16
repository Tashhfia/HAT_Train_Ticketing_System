
package train_ticketing_system;

import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.IOException;
import java.io.BufferedWriter;
import java.util.Scanner;
import java.io.*;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Confirm_List {
    
    String name;
    String IC;
    int number;
    public static int i = -1;
    
    
 public Confirm_List(){
     name = null;
     IC = null;
     number = 0;
 }

 public static void  info() {
     System.out.println("=======================");
     File f = new File("Confirm_list.txt");
       if (!f.exists()) {
           try {
             f.createNewFile();
           }
           catch (IOException ex) {
             Logger.getLogger(Confirm_List.class.getName()).log(Level.SEVERE, null, ex);
           }
        }
        else {
            try {
                FileReader p = new FileReader("Confirm_list.txt");
                BufferedReader r = new BufferedReader(p);
                
                FileWriter fw = new FileWriter(f,true);
                BufferedWriter pw = new BufferedWriter(fw);
                
                String line = null;
                Scanner sc = new Scanner(System.in);
                 
                while (((line = r.readLine()) != null) && i < 5){
                    i++;
                }
                
                if(i >= 5) {
                    System.out.println("All seats are full......\n Would you like to be added to the waiting list? \n 1. Yes \n 2. No");
                    int rep = sc.nextInt();
                    
                    switch(rep){
                        
                        case 1:{
                            Waiting_List q1 = new Waiting_List();
                            q1.waitingInfo();
                            break;
                        }
                        
                        case 2: {
                            System.out.println("Please select another date....");
                            break;
                        }
                        
                        default:
                            System.out.println("Invalid response.....");
                            break;
                    }
                }
                else {
                            
                    System.out.println("Enter your name:");
                    String inp = sc.next();
                    
                    System.out.println("Enter your IC: ");
                    String ic = sc.next();
                    
                    System.out.println("Enter your phone number: ");
                    String pnNum = sc.next();
                    
                    Random rr = new Random(); 
                    int ticketNo;
                    ticketNo = 100 + rr.nextInt(400);
                    String tNo = "CL" + ticketNo;
                    
                    int seatNum = 1 + i;
                 
                    System.out.println("Your ticket has been booked successfully and your ticket number is " + tNo + " and your seat number is " + seatNum);
                    
                    pw.write(inp+"    "+ic+"    "+pnNum +"   " + tNo +"   " + seatNum);
                    
                    pw.newLine();
                    pw.close();
                    }
                              
                }
            catch (IOException ex) {
                Logger.getLogger(Confirm_List.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
    }
}
        
        
        
    




    
    

