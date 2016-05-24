/*
  Detect cycle in the list
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int HasCycle(Node head) {
    Node turtle = head;
    Node hare = head;
    
    while(hare!=null){
        turtle = turtle.next;
        hare = hare.next.next;
        
        if(turtle == hare)
            return 1;
    }
    
    return 0;
}
