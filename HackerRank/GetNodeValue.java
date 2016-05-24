/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
    
int GetNode(Node head,int n) {
     // This is a "method-only" submission. 
     // You only need to complete this method. 
    Node temp = head;
    int i = 0;
    
    while(temp!=null){
        temp = temp.next;
        i++;
    }
    i--;
    
    temp = head;
    while(temp!=null){
        if(i==n){
            return temp.data;
        }
        
        temp = temp.next;
        i--;
    }
    
    return 0;

}
