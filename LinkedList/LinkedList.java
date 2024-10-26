package LinkedList;

public class LinkedList {
    
    // Creating head and tail
    public Node head;
    public Node tail;
    public int size;

    // method to create singly linked list
    public Node createSinglyLinkedList(String nodeValue){
        
        head = new Node(); // initialize head with the value of empty node
        Node node = new Node(); // creating an instance of node class
        node.next = null;
        node.value = nodeValue;

        // Reference head and tail to created node
        head = node;
        tail = node;

        size = 1;
        return head;
    }

    // Insert method for adding nodes to the list
    public void insertInLinkedList(String nodeValue, int location){

        Node node = new Node();
        node.value = nodeValue;

        // check if the linked is created
        if (head == null){
            createSinglyLinkedList(nodeValue);
            return;
        }

        if (location == 0){  // Location = 0 (Begining)
            node.next = head; // copy reference from head to the new node
            head = node; // copy reference of new node to head
        } else if (location >= size) { // Location >= Size (End)
            node.next = null; // set new node referencce to null
            tail.next = node; // set current last node reference to this new node
            tail = node; // set tail reference to new node
        } else { // (Middle)
            Node tempNode = head;
            int index = 0;

            while (index < location - 1) {
                tempNode = tempNode.next;
                index++;
                // at the end of this loop, tempNode location is the 
                // current node we need to insert new node after
            }

            // Insert New Node
            Node nextNode = tempNode.next;
            tempNode.next = node;
            node.next = nextNode;
        }
        size++;
    } 

    // Singly Linked List Traverse
    public void traverseSinglyLinkedList(){

        if (head == null) {
            System.out.println("Linked List does not exists");
        } else {
            Node tempNode = head;
            for (int i=0; i < size; i++){
                System.out.print(tempNode.value);
                if (i != size - 1) {
                    System.out.print(" -> ");
                }
                tempNode = tempNode.next;
            }
        }
        System.out.println("\n");
    }

    // Delete a node from linked list
    public void deleteNode(int location){

        // check if the linked is created
        if (head == null){
            System.out.println("Thi linked list does not exist");
            return;
        }

        if (location == 0){ // Begining
            head = head.next;
            size--;
            if (size == 0){
                tail = null;
            }
        }
        else if (location >= size) { // end
            Node tempNode = head;
            for (int i=0; i < size - 1; i++){
                tempNode = tempNode.next;
            }

            if(tempNode == head){
                tail = head = null;
                size--;
                return;
            }

            tempNode.next = null;
            tail = tempNode;
            size--;
        }
        else { // Middle
            Node tempNode = head;
            for (int i=0; i < location - 1; i++){
                tempNode = tempNode.next;
            }

            tempNode.next = tempNode.next.next;
            size--;
        }
    }

    // Search Specific value
    public void searchItem (String valueToSearch){
        Node tempNode = head;
        for (int i=0; i < size - 1; i++){
            if (tempNode.value == valueToSearch){
                System.out.println(valueToSearch + " Found on location " + i);
                return;
            }
            tempNode = tempNode.next;
        }
    }





}
