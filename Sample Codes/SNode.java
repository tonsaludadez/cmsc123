class SNode{
	int item;
	SNode next;

	public SNode(int item){
		this.item = item;
		next = null;
	}

	public SNode(int item, SNode next){
		this.item = item;
		this.next = next;
	}
	public static void main(String[] args) {
		SNode a = new SNode(1);
		SNode b = new SNode(2,a);
		SNode c = new SNode(3,b);

		SNode.printNode(c);
		System.out.println();
		System.out.println();
		SNode d = c.reverseFib(c);
		System.out.println();
		SNode.printNode(d);
	}

	public SNode reverseFib(SNode L){
		if(L.next == null || L == null){
			//System.out.println("1. L is null or L next is null, will return: " + L.item);
			return L;
		}

		SNode temp = reverseFib(L.next);
		//System.out.println("2. Temp item is: " + temp.item);
		SNode temp2 = L.next;
		//System.out.println("3. temp2 item is now: " + temp2.item);
		temp2.next = L;
		//System.out.println("4. temp2 next item is now: " + temp2.next.item);
		L.next = null;



		//System.out.println("5. Temp that will be returned is: " + temp.item);
		return temp;
	}

	public static void printNode(SNode L){
		SNode temp = L;

		while(temp!=null){
			System.out.print(temp.item + " ");
			temp = temp.next;
		}
	}
}