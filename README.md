# HAT_Train_Ticketing_System
A group project for a university course where we were assigned to develop a train ticketing system using java. 
The train ticketing system would be used for booking trains from Kuala Lumpur to Johor Bahru. The line has one train each day for only five passengers. The system is used for booking tickets on the dates available. It is also used for viewing passenger tickets and can be used to update their information or delete their ticket. It also informs the user whether they are in the confirmed list for the train or in the waiting list. The system updates automatically if someone deletes their ticket from the confirmed list.

## How the system works:
The system starts by asking the user if they want to:
•	Book a ticket       Or
•	View an already existing ticket

## Confirm_List class:
The info() method starts by asking the user to enter their preferred date of travel.
It uses a linked list to search for the dates.
If the date is not available, it displays the message “Date unavailable”.
If the date is available, the system takes them to the booking screen where it prompts them to enter their name, IC number and phone number.
It then assigns them a ticket number and a seat number. It stores all the information in a text file called Confirm_list.txt.
If the train is full, it asks the user if they want to be added to the waiting list. If they answer yes, the system goes to the Waiting List class.

## Waiting_List Class:
The waitingInfo() prompts the passenger for their details. It stores the information in a separate text file called Waiting_list.txt.
It then adds the passenger to the waiting list using the enqueue() method.

## View_ticket class: 
The View() method asks the user if they want to view:
  •	Status() of their ticket
  •	Edit() the information in their ticket
  •	Delete() their ticket

Status() prompts the user for their ticket number and tells the user if they are in the confirmed list or waiting list.
Edit() prompts the user for ticket number and retrieves their details. It then asks the user if they want to change their:
  1.	Name    or
  2.	IC number   or
  3.	Phone number
   
Delete() prompts the user for their ticket number and then their seat number. It then proceeds to remove the passenger from the confirmed list and dequeues the first passenger from the waiting list to the confirmed list.

## Date_list class:
It is used by the system manager to store available dates for the trains using linked lists.
It searches for the date in the nodes when the passenger prompts the system using the search() method.

