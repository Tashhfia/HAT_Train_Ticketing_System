
package train_ticketing_system;

public class Date_list {
    public Train_ticketing_system tail; // a node named tail created 
    int d;
    String m;
    
    public Date_list(){
       tail = null;  // tail must point to null initially
    }
    
    public void addNode ( int date, String month, int year) {
        Train_ticketing_system node = new Train_ticketing_system(date,month,year);
        node.next = tail;
        tail = node;
    }
    
    public void display (){
        Train_ticketing_system node = tail;
        //as long as its not empty
        while(node != null) {
          node.display();
          node = node.next; //move on to next node
        }    
        System.out.println("-----------------------------------");
    }
        
       
    public Train_ticketing_system search(int d, String m) {
        Train_ticketing_system current = tail;
      
        
        while((current.date != d )&& (current.month != m)){
            if (current.next == null) {
                System.out.println("Date unavailable");
                return null;
            }
            else {
                current = current.next;
            }
        }
    
        current.display();
          System.out.println("Welcome to the booking screen!");
          Confirm_List b = new Confirm_List();
          b.info();
          return current;
    } 
}
