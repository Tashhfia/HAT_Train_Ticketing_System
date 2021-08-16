
package train_ticketing_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;



public class View_ticket {
    
 public static void View() {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Do you want to \n 1.View the status \n 2.Edit your ticket \n 3.Delete your ticket");
        int num1 = sc.nextInt();
        
        if (num1 == 1){
            Status();
        }
        else if (num1 ==2){
            Edit();
        }
        else if(num1 == 3){
            Delete();
        }
        else{
            System.out.println("Invalid option");
        }
 }
 
 public static void Status(){
        System.out.println("Please enter your ticket number.");
        Scanner sc = new Scanner(System.in);
        String tnum = sc.next();
           
        try{
            FileReader p = new FileReader("Confirm_list.txt");
            BufferedReader r = new BufferedReader(p);
            
            String line = null;
            
            while((line = r.readLine()) != null){
                if(line.contains(tnum)){
                System.out.println("You are in the confirmed list.");
                }
            }
            
            FileReader q = new FileReader("Waiting_list.txt");
            BufferedReader r1 = new BufferedReader(q);
            
            String  line1 = null;
            
            while((line1 = r1.readLine()) != null){
                if(line1.contains(tnum)){
                    System.out.println("You are in the waiting list.");
                }
            }
        }
        catch (IOException ex) {
            Logger.getLogger(Confirm_List.class.getName()).log(Level.SEVERE, null, ex);
        }
 }
 
 public static String[] txttoArray(){
        try {
            int ctr = 0;
            Scanner sc = new Scanner(new File("Confirm_list.txt"));
            Scanner s = new Scanner(new File("Confirm_list.txt"));
           
            while(sc.hasNext()){
                ctr++;
                sc.next();
            }
            
            String[] txtline = new String[ctr];
            for (int i = 0; i < ctr; i++) {
                txtline[i] = s.next();
            }
            
            for (int i = 0; i < txtline.length; i++) {
                System.out.print(txtline[i]+"\n");
            }
        } 
        catch (Exception e) {
            System.out.println("er");
        }
        return null ;
 }
 
 public static void Edit(){
     try{
        FileWriter fw = new FileWriter("Confirm_list.txt",true);
        BufferedWriter pw = new BufferedWriter(fw);
         
        FileReader p = new FileReader("Confirm_list.txt");
        BufferedReader r = new BufferedReader(p);
            
        String line = null;
         
        Scanner s = new Scanner(System.in);
         
        System.out.println("Please enter your ticket number: ");
        String ans = s.next();
         
        while((line = r.readLine()) != null){ 
              
        if(line.contains(ans)){
          System.out.println("Your current information: "+ "\n"+line);
          
          System.out.println("What do you want to edit? \n 1.Name  \n 2.IC number \n 3.Phone number");
           
          int num = s.nextInt();
            switch (num){
               case 1:  {
               
                System.out.println("Enter new name:");
                String newName = s.next();
                
                Charset charset = Charset.defaultCharset();
                Path path = Paths.get("Confirm_list.txt");
                List<String> lines = Files.readAllLines(path, charset);
                
                System.out.println("Enter your seat number:");
                int sNo = s.nextInt();
                
                String header = lines.get(sNo);
                header = header.replaceFirst("^\\S+",newName);
                lines.set(sNo, header);
                
                Files.write(path, lines, charset);
                System.out.println("===================");
                
               }
               break;
               
               case 2 : {
                 System.out.println("Enter old IC");
                 String oldIc = s.next();
        
                 System.out.println("Enter new IC:");
                 String newIc = s.next();
                       
                 Charset charset = Charset.defaultCharset();
                 Path path = Paths.get("Confirm_list.txt");
                 List<String> lines = Files.readAllLines(path, charset);
                 
                 System.out.println("Enter your seat number:");
                 int sNo = s.nextInt();
                 
                 String header = lines.get(sNo);
                 header = header.replace(oldIc,newIc);
                 lines.set(sNo, header);
                 
                 Files.write(path, lines, charset);
                 System.out.println("===================");
               }
               break;
               
               case 3: {
                   
                  System.out.println("Enter old phone number;");
                  String oldnum = s.next();
        
                  System.out.println("Enter new phone number:");
                  String newnum = s.next();
                   
                  Charset charset = Charset.defaultCharset();
                  Path path = Paths.get("Confirm_list.txt");
                  List<String> lines = Files.readAllLines(path, charset);
                   
                  System.out.println("Enter your seat number:");
                  int sNo = s.nextInt();
                   
                  String header = lines.get(sNo);
                  header = header.replace(oldnum,newnum);
                  lines.set(sNo, header);
                   
                  Files.write(path, lines, charset);
                  System.out.println("===================");
               }
               break;
               
               default: {
                   System.out.println("Option not available");
               }
               break;
            }
         }
        }
        pw.close();
        r.close();
        p.close();
        fw.close();
     }
     catch (IOException ex) {
         Logger.getLogger(Confirm_List.class.getName()).log(Level.SEVERE, null, ex);
     }
 }

 public static void Delete() {
     try{
        FileWriter fw = new FileWriter("Confirm_list.txt",true);
        BufferedWriter pw = new BufferedWriter(fw);
            
        FileReader p = new FileReader("Confirm_list.txt");
        BufferedReader r = new BufferedReader(p);
           
        FileReader p1 = new FileReader("Waiting_list.txt");
        BufferedReader r1 = new BufferedReader(p1);
        
        String line = null;
        Scanner s = new Scanner(System.in);
        
        System.out.println("Please enter your ticket number: ");
        String ans = s.next();
        
        while((line = r.readLine()) != null){
            if(line.contains(ans)){
                String linef = null;
                linef =r1.readLine();
                
                Charset charset = Charset.defaultCharset();
                Path path = Paths.get("Confirm_list.txt");
                List<String> lines = Files.readAllLines(path, charset);
                
                System.out.println("Enter your seat number:");
                int sNo = s.nextInt();
    
                String header = lines.get(sNo);
                header = header.replaceAll(line, linef);
                lines.set(sNo, header);
                
                Files.write(path, lines, charset);
                
                Waiting_List w1=new Waiting_List();
                w1.dequeue();
            }
        }
     }
     catch (IOException ex) {
         Logger.getLogger(Confirm_List.class.getName()).log(Level.SEVERE, null, ex);
     }
 }
}

