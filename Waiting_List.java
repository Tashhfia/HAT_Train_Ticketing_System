package train_ticketing_system;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Waiting_List {
int maxSize, head, tail;
String queue[]; 

 public Waiting_List(){
maxSize=5 ;
head = 0; 
tail = 0;
queue = new String[maxSize] ;

}

boolean isEmpty() {
    return tail == 0 ;
}

boolean isFull(){
    return tail >= maxSize;
}

public void waitingInfo(){
      Scanner sc = new Scanner(System.in);
      
            File W = new File("Waiting_list.txt");
        if (!W.exists()) {
            try {
                W.createNewFile();
            } catch (IOException ex) {
                Logger.getLogger(Confirm_List.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        else {
            try{
           FileWriter fw = new FileWriter(W,true);
           BufferedWriter pw = new BufferedWriter(fw);
                   System.out.println("Enter your name:");
                   String inp = sc.next();
                   System.out.println("Enter your IC: ");
                   String ic = sc.next();
                   System.out.println("Enter your phone number: ");
                   String pnNum = sc.next();
                    Random rr = new Random(); 
                int ticketNo;
                ticketNo = 100 + rr.nextInt(400);
                String tNo = "WL" + ticketNo;
                 
               System.out.println("Your ticket has been booked successfully and your ticket number is " + tNo);
           pw.write(inp+"    "+ic+"    "+pnNum +"   " + tNo);
           pw.newLine();
           pw.close();
           
           FileReader p = new FileReader("Waiting_list.txt");
           BufferedReader r = new BufferedReader(p); 
                       String line;
                       while(((line = r.readLine()) != null)) {
                        
                       enqueue(line);
                       
                       }
                       //display();
                       r.close();
                       
        }
         catch (IOException ex) {
                   Logger.getLogger(Confirm_List.class.getName()).log(Level.SEVERE, null, ex);
               }
        
  }
}

public void enqueue(String s){
        if(isEmpty()){
            queue[head]=s;
            tail++;
        }
        else{
            if(isFull()){
                System.out.println("Queue overload!");
            }
            else{
                queue[tail]=s;
                tail++;
            }
        }
    }
public void dequeue(){
     
   String temp = null;
    if(isEmpty())
            System.out.println("Queue is empty");
    else{
         temp= queue[head];
        for (int i=0;i<tail-1;i++)
            queue[i]=queue[i+1];
    }
    tail--;
       
        System.out.println(temp);  
        System.out.println("*******************");     
    
      try{
        Scanner s = new Scanner(System.in);
        
        FileWriter fw = new FileWriter("Waiting_list.txt",true);
        BufferedWriter pw = new BufferedWriter(fw);
         
        FileReader p = new FileReader("Waiting_list.txt");
        BufferedReader r = new BufferedReader(p);
        
        String line = "  ";
        String linef = null;
        linef =r.readLine();
        
        Charset charset = Charset.defaultCharset();
        Path path = Paths.get("Waiting_list.txt");
        List<String> lines = Files.readAllLines(path, charset);
        
        System.out.println("Enter 0 to confirm");
        int No = s.nextInt();
        
        String header = lines.get(No);
        header = header.replaceAll(line, linef);
        lines.set(No, header);
        
        Files.write(path, lines, charset);
                
       }
      catch (IOException ex) {
          Logger.getLogger(Confirm_List.class.getName()).log(Level.SEVERE, null, ex);
     }
    }

public void display(){
        for(int i=0;i<tail;i++)
            System.out.println(queue[i]);
}

public static String[] txttoArray(){
        try {
            int ctr = 0;
            Scanner sc = new Scanner(new File("Waiting_list.txt"));
            Scanner s = new Scanner(new File("Waiting_list.txt"));
            while(sc.hasNext()){
                ctr++;
                sc.next();
            }
            String[] queue = new String[ctr];
            for (int i = 0; i < ctr; i++) {
                queue[i] = s.next();
            }
            for (int i = 0; i < queue.length; i++) {
              //  System.out.print(queue[i]+"\n");
                
            }
        } catch (Exception e) {
            System.out.println("er");
        }
        return null ;
}
   
}

