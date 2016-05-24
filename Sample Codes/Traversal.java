class Node{
	Object item;
	Node left;
	Node right;
	Node(Object item){
		this.item = item;
		left = right = null;
	}

	static void preorder(Node node){
		if(node == null) return;
		System.out.println(node.item);
		preorder(node.left);
		preorder(node.right);
	}

	static void inorder(Node node){
		if(node == null) return;
		inorder(node.left);
		System.out.println(node.item);
		inorder(node.right);
	}

	static void postorder(Node node){
		if(node == null) return;
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.item);
	}
}

class Test{
	public static void main(String[] args) {
		Node a = new Node("a");
		Node b = new Node("b");
		Node c = new Node("c");
		Node d = new Node("d");

		a.left = b;
		a.right = c;
		b.right = d;

		Node.preorder(a);
		Node.inorder(a);
		Node.postorder(a);
	}
}