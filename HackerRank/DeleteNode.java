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

Node Delete(Node head, int position) {
    Node temp = head;
    int ctr = 0;
    
    if(position == 0){
        return head.next;
    }
    
    else{
        while(ctr+1<position){
            temp = temp.next;
            ctr++;
        }
        
        temp.next = temp.next.next;
              
    }
    
    return head;

}