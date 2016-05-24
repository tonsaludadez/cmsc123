/*
  Insert Node at the end of a linked list 
  head pointer input could be NULL as well for empty list
  Node is defined as 
  class Node {
     int data;
     Node next;
  }
*/
int FindMergeNode(Node headA, Node headB) {
    // Complete this function
    // Do not write the main method. 
    Node tempA = headA;
    Node tempB = headB;
    
    while(tempA!=null){
        while(tempB!=null){
            if(tempA.data==tempB.data)
                return tempA.data;
            else
                tempB = tempB.next;
        }
        
        tempA = tempA.next;
        tempB = headB;
    }
    
    return 0;
}
