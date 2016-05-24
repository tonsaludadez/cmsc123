import java.util.LinkedList;
import java.util.Iterator;

interface Stack{
	public void push(Object o);
	public Object pop();
	public Object top();
	public int size();
	public boolean isEmpty();
}

class StackEmptyException extends RuntimeException{

}

class StackA implements Stack{
	private LinkedList list;
	private int size;

	StackA(){
		list = new LinkedList();
		size = 0;
	}
	public void push(Object o){
		list.addFirst(o);
		size++;
	}
	public Object pop(){
		if(isEmpty()){
			throw new StackEmptyException();
		}
		Object o = list.removeFirst();
		size--;
		return o;
	}
	public Object top(){
		return list.getFirst();
		//return list.get(0);
	}
	public int size(){
		return size;
	}
	public boolean isEmpty(){
		return size == 0;
	}
	public String toString(){
		Iterator i = list.listIterator(0);
		String s = "";
		while(i.hasNext()){
			s += i.next()+"\n";
		}
		return s;
	}
}
 
 /*class TestS{
 	public static void main(String[] args){
 		StackA s = new StackA();
 		System.out.println("size:"+s.size());	
 		System.out.println(s);
 		System.out.println("push 1");
 		s.push(1);
 		System.out.println(s);
 		System.out.println("push 2");
 		s.push(2);
 		System.out.println(s);
 		System.out.print("top:");
 		Object o = s.top();
 		System.out.println(o);
 		System.out.println(s);
 		System.out.print("pop:");
 		o = s.pop();
 		System.out.println(o);
 		System.out.println(s);
 		System.out.print("pop:");
 		o = s.pop();
 		System.out.println(o);
 		System.out.println(s);
 		System.out.print("pop:");
 		o = s.pop();
 		System.out.println(o);
 		System.out.println(s);

 	}
 }*/
