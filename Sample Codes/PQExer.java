interface PQ{
	Entry min();
	Entry removeMin();
	Entry insert(int key, Object value);
	int size();
	boolean isEmpty();
}
class Entry{
	int key;
	Object value;

	Entry(int key, Object value){
		this.key = key;
		this.value = value;
	}
}

class PQArray implements PQ{
	Entry[] ar;
	int size;
	int index;
	final int ROOT = 1;

	PQArray(){
		size = 0;
		index = 1;
		ar = new Entry[10];
	}
	PQArray(Entry[] a){
		ar = new Entry[a.length];
		for (int i=0;i<a.length ;i++ ) {
			ar[i] = a[i];
		}
		size = a.length-1;
		index = a.length;
	}

	public Entry min(){
		if(size==1)
			return ar[ROOT];
		return null;
	}
	public Entry removeMin(){
		//if size is zero return null

		
		//get the entry at the root

		//take note of the last element index

		//take note of the last element entry

		//track the hole from the root 

		//check smaller child from the hole index

		//while the smaller index is not the last element index
		//and while the key at the last element is > than the smaller child

			//put the smaller child at the hole index

			//move down the hole

			//get the index of the smaller child of the new hole

		
		//when the loop exits, the hole index is where you put the last element

		//decrement the size and index

		//return the entry
		return null;
	}
	private int smallerChildIdx(int hole){
		int lc = hole*2;
		int rc = hole*2+1;
		int idx = lc;
		if((rc<index-1) && ar[rc].key<ar[lc].key)
			idx = rc;
		return idx;
	}
	public Entry insert(int key, Object value){
		//create a new entry object
		
		//get the parent index of the next available position
		
		//initialize the hole variable to hold the index position
		
		//loop until the parent index becomes the root and
		//while the key to be inserted is less than the parent key
		
			//copy to the hole index the parent entry
		
			//move the hole index up
		
			//go to the parent of the parent
		
		
		//when the loop exits, the hole index holds the entry to be inserted
		
		//increment index and size
		
		//return the entry
		return null;
	}

	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size==0;
	}
	public String toString(){
		String s = "";
		for (int i=1;i<size+1;i++) {
				s = s+ ar[i].key+" ";
		}
		return s;
	}


	void bottomUpHeap(){
		//if size is zero then return null
		//if size 1 then that is the heap
		

		//get index of last parent
		
		//declare a temporary entry variable to be used for swapping entries
		
		//do the following
		
			//get the index of the smaller child starting from the last parent index
			
			//swap if parent is greater than the smaller child
			




			//move to the next parent
			
		//until the next parent becomes the root	
	}
}
class TestPQ{
	public static void main(String[] args){
		PQArray p = new PQArray();
		p.insert(5, "test");
		p.insert(0, "test");
		p.insert(2, "test");
		p.insert(7, "test");
		p.insert(6, "test");
		p.insert(4, "test");
		p.insert(3, "test");
		System.out.print(p);
		System.out.println("should be 0 5 2 7 6 4 3");
		System.out.print(p.min()!=null?p.min().key:null);
		System.out.println(" should be 0");
		System.out.print(p.removeMin()!=null?p.removeMin().key:null);
		System.out.println(" should be 0");
		System.out.print(p);
		System.out.println(" should be 2 5 3 7 6 4");
		System.out.print(p.removeMin()!=null?p.removeMin().key:null);
		System.out.println(" should be 2");
		System.out.print(p);
		System.out.println(" should be 3 5 4 7 6");
		System.out.print(p.removeMin()!=null?p.removeMin().key:null);
		System.out.println(" should 3 ");
		System.out.print(p);
		System.out.println(" should 4 5 6 7");

		Entry[] a = {null,
					new Entry(2,""),
					new Entry(0,""),
					new Entry(5, ""),
					new Entry(3,""),
					new Entry(7,""),
					new Entry(4,""),
					new Entry(6,"")
					};
		PQArray q = new PQArray(a);
		q.bottomUpHeap();
		System.out.print(q);
		System.out.println("shoud be 0 2 4 3 7 5 6");

	}
}