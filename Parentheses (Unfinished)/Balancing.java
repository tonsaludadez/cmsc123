class Balancing{
	public static final String OPEN = "{([";
	public static final String CLOSE = "}])";

	public static void main(String[] args){
		String[] a = {"[]","{{","{)(}","{","{}[]","{{}","{[}]","(/","{({[]})}","{([)]}"};
		for(String str:a){
			System.out.println(str+":"+isBalanced(str));
		}
	}
	public static boolean isBalanced(String s){
        StackA stack = new StackA();
        for (int i = 0; i < s.length(); i++) {

            System.out.println("check!!" + s.charAt(i));
 
            if (s.charAt(i) == OPEN.charAt(0))
            	stack.push(OPEN.charAt(0));

            else if (s.charAt(i) == OPEN.charAt(1))
                stack.push(OPEN.charAt(1));

            else if (s.charAt(i) == OPEN.charAt(2))
                stack.push(OPEN.charAt(1));

            else if (s.charAt(i) == CLOSE.charAt(2)){
                if (stack.isEmpty())        
                	return false;
                if (stack.pop() != Character.toString(OPEN.charAt(1))) 
                	return false;
            }

            else if (s.charAt(i) == CLOSE.charAt(0)) {
                if (stack.isEmpty())        
                	return false;
                if (stack.pop() != Character.toString(OPEN.charAt(0)))
                	return false;
            }

            else if (s.charAt(i) == CLOSE.charAt(2)) {
                if (stack.isEmpty())        
                	return false;
                if (stack.pop() != Character.toString(OPEN.charAt(1)))
                	return false;
            }

            System.out.println("stack: " + stack);
        }

        return stack.isEmpty();
    }
}