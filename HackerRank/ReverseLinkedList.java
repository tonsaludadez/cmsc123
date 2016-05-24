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
Node Reverse(Node head) {
    if(head.next == null || head == null){
			return head;
		}

		Node temp = Reverse(head.next);
		Node temp2 = head.next;
		temp2.next = head;
		head.next = null;

		return temp;
}