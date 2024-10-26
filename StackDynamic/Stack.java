package StackDynamic;

import java.util.ArrayList;
import java.util.List;

public class Stack {
    
    // declare linked list
    LinkedList linkedList;

    public Stack() {
        this.linkedList = new LinkedList();
    }

    // Push (Insert)
    public void push(String value){
        linkedList.insertInLinkedList(value, 0);//----->O(1)
        System.out.println("Value added to the Stack");
    }

    // isEmpty
    public boolean isEmpty(){
        if (linkedList.head == null){
            return true;
        } else {
            return false;
        }
    }

    // Pop (Remove)
    public String pop(){
        String value = "NotFound";

        if (isEmpty()){
            System.out.println("Stack is empty");
        } else {
            value = linkedList.head.value;
            linkedList.deleteNode(0);//---->O(1)            
        }
        return value;        
    }

    // Peek
    public String peek(){
        String value = "NotFound";

        if (isEmpty()){
            System.out.println("Stack is empty");
        } else {
            value = linkedList.head.value;//---->O(1)
        }
        return value;        
    }

    // Delete Stack
    public void delete(){
        linkedList.head = null;
        System.out.println("Stack is Deleted");
    }

    public int getStackSize(){
        return linkedList.size;
    }

// ---------------------------------------------
public List<List<Integer>> subsets(List<Integer> nums) {
    List<List<Integer>> result = new ArrayList<>();
    generateSubsets(nums, 0, new ArrayList<>(), result);
    return result;
}

private void generateSubsets(List<Integer> nums, int index, List<Integer> current, List<List<Integer>> result) {
    if (index == nums.size()) {
        result.add(new ArrayList<>(current));
        return;
    }
    generateSubsets(nums, index + 1, current, result);
    current.add(nums.get(index));
    generateSubsets(nums, index + 1, current, result);
    current.remove(current.size() - 1);
}


}


