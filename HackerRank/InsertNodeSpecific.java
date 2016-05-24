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

Node InsertNth(Node head, int data, int position) {
    int ctr = 0;
    Node temp = head, next = new Node();
    next.data = data;
    
    if(position == 0){
       next.next = head;
       return next;
    }
    else{
        while(ctr+1<position){
            temp = temp.next;
            ctr++;
        }
    
    
    next.next = temp.next;
    temp.next = next;
    
    return head;
    }
    
}
