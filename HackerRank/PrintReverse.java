/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    // This is a "method-only" submission. 
    // You only need to complete this method. 

void ReversePrint(Node head) {
  // This is a "method-only" submission. 
  // You only need to complete this method. 
    Node temp = head;
    
    String rev = "";
    
    while(temp!=null){
        String tempStr = String.valueOf(temp.data) + "\n";
        tempStr = tempStr.concat(rev);
        rev = tempStr;
        temp = temp.next;
    }
    
    System.out.print(rev);
}
