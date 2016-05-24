/*
	part8 coding of the exam
*/

class SLNode{
	int item;
	SLNode next;

	SLNode(int item){
		this.item = item;
		next = null;
	}

	public String toString(){
		return this.item + " ";
	}
}

class part8{
	public static void main(String[] args) {
		SLNode a,b,c,d, temp;
		a = new SLNode(1);
		b = new SLNode(2);
		c = new SLNode(3);
		d = new SLNode(4);
		a.next = b;
		b.next = c;
		c.next = d;

		temp = a;

		System.out.print("Original list: ");
		while(temp!=null){
			System.out.print(temp);
			temp = temp.next;
		}

		System.out.println("");

		SLNode e = part8.reverse1(a);

		System.out.print("Reversed list 1 (non destructive): ");
		while(e!=null){
			
			System.out.print(e);
			e = e.next;
		}

		System.out.println("");

		SLNode f = part8.reverse2(a);

		System.out.print("Reversed list 2 (destructive): ");
		while(f!=null){

			System.out.print(f);
			f = f.next;
		}

		System.out.println("");
	}

	/**
	*	reverse1 reverses a list non-destructively
	*/
	public static SLNode reverse1(SLNode head){
		if(head == null || head.next == null){
			return head;
		}

		// SNode revList
		SLNode temp = null;

		while(head!=null){
			SLNode revList = new SLNode(head.item);
			//System.out.println("Created node: " + revList);
			revList.next = temp;

			head = head.next;
			temp = revList;
		}

		//System.out.println("Temp is now: " + temp);
		return temp;
	}

	/**
	*	reverse2 reverses a list destructively
	*/
	public static SLNode reverse2(SLNode head){
		if(head == null || head.next == null){
			//System.out.println("Returning head: " + head);
			return head;
		}

		SLNode rev = reverse2(head.next);
		//System.out.println("rev is: " + rev);
		SLNode temp = head.next;
		//System.out.println("temp is: " + temp);
		temp.next = head;
		head.next = null;

		//System.out.println("Returning rev: " + rev);
		return rev;
	}
}