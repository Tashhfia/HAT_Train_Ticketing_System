
package train_ticketing_system;

import java.util.Scanner;


public class Train_ticketing_system {
    int date;
    String month;
    int year;
    Train_ticketing_system next;
    
    public Train_ticketing_system (int date, String month, int year){
        this.date = date;
        this.month = month;
        this.year = year;
    }
    
    public void display(){
        System.out.println(date+" "+ month+ " "+ year);
    }

    
    public static void main(String[] args) {
        
            Date_list D = new Date_list();
            D.addNode(01, "Jan", 2020);
            D.addNode(02, "Jan", 2020);
            D.addNode(03, "Jan", 2020);
            D.addNode(04, "Jan", 2020);
            D.addNode(05, "Jan", 2020);
            D.addNode(06, "Jan", 2020);
            D.addNode(07, "Jan", 2020);
            int i = 1;
            
            Scanner sc = new Scanner(System.in); 
            while (i < 2){
            System.out.println("Welcome to HAT railway booking system! ");
           
            System.out.println("1. Book a ticket.\n2. View your ticket. \n3. Exit");
            int rep = sc.nextInt();
            
            switch(rep) {
              case 1: {
            
               System.out.println("Please enter the day of your travel: ");
               int d = sc.nextInt();
               System.out.println("Please enter the month of your travel: ");
               String m = sc.next();
               D.search(d,m);
               break;
              }
              
              case 2: {
                  View_ticket.View();
                  break;
              }
              
              case 3:{
                  i++;
                  break;
              }
              
              default:{
                  System.out.println("Option not available");
                  break;
              }
            }  
            }
    }
}