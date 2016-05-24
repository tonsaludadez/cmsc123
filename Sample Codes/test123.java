/*
	levelOrder Traversal
*/

import java.util.*;

class Node {
       String data;
       Node left;
       Node right;

       Node(String data){
       		this.data = data;
       		left = right = null;
       }
}

class test123{

	public static void main(String[] args) {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");

		a.left = b;
		a.right = c;
		b.right = d;

		test123.levelOrder(a);
	}

	static void levelOrder(Node n){
		if(n != null){

		    Queue<Node> queue = new LinkedList<Node>();
		    queue.add(n);
		 
		    while (!queue.isEmpty()){
		        Node temp = queue.remove();

		        if (temp.left != null){
		            queue.add(temp.left);
		        }

		        if (temp.right != null){
		            queue.add(temp.right);
		        }

		        System.out.println(temp.data);
		    }
		}

		else{
			System.out.println("Node is null");
		}

	}
}