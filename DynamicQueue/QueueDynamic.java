package DynamicQueue;

public class QueueDynamic {
     // declare a linked list object
   LinkedList list;

   // Create queue using constructor method
   public QueueDynamic() {
      list = new LinkedList();
      System.out.println("Dynamic Queue Created");
   }

   // isEmpty Method
   public boolean isEmpty(){
      if (list.head == null) {
         return true;
      }
      else {
         return false;
      }
   }

   // enQueue Method (Insert)
   public void enQueue(String value){
      list.insertInLinkedList(value, list.size);
      System.out.println(value + " added to the queue");
   }

   // deQueue Method (Removing)
   public String deQueue(){

      String returnValue = "EMPTY";

      if(isEmpty()){
         System.out.println("The queue is empty");
      } else {
         returnValue = list.head.value;
         list.deleteNode(0);
      }
      
      return returnValue;
   }

   // Peek Method
   public String peek(){

      String returnValue = "EMPTY";

      if(isEmpty()){
         System.out.println("The queue is empty");
      } else {
         returnValue = list.head.value;
      }

      return returnValue;
   }

   // Delete Queue
   public void deleteQueue(){
      list.head = null;
      list.tail = null;
      System.out.println("Queue is deleted");
   }

   // View Queue Elements 
   public void viewAllElements(){
      list.traverseSinglyLinkedList();
   }


}
