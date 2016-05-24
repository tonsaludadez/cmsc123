class Lab5{
	public static void main(String[] args){
		X[] xa = new X[5];
		Y[] ya = new Y[5];
		X x = new X();
		Y y = new Y();

		Y y2 = y;
		X x2 = x;

		
		//I(a) and I(b)
		//xa = ya;	  //can be assigned compile time and running time
		//ya = (Y[])xa; //in compile time, a cast is required since "xa" is type X[], not Y[].
					  //no runtime error if there is a cast. xa can be assigned to ya if xa references
					  //	an array of Y
		
		
		
		//I(c)
		//ya = xa;    //cannot assign xa to ya since xa references an array of X, which is the
					  //	super class of Y. ya references array of Y, the subclass. But if xa 
					  //	references an array of Y[], and there is a cast, it is possible for
					  //    xa be assigned to ya. 
		

		//II(a)
		//y.method();	  //class Y overrides the method
		
		//II(b)
		//y.method();	  //cannot change the return type
		
		//II(c)
		//y.method("Hello");//both methods will run even if there is a different parameter type since they 
		//y.method(5);	  //	are seen as 2 different methods that doesnt override anything

		//II(d)
		//y.method(5);	  //no problem

		//III(a)		  //the code will still compile whether the constants values are the same or not

		//III(b) and III(c)
		//y.main();		  //it wont compile if "testInterface" or "X" is not specified in accessing the CONST variable

		//IV(a)
		//((X)y2).method4();//java will call the subclass method

		//IV(b)
		//((Y)x2).method4();//X cannot be casted to Y

		//IV(c)
		//y2.method4();	//cannot directly call the superclass method since the method is overidden in the subclass
						//	but the superclass method can be called if passing through the subclass method is allowed
						//	by calling the "super.method4()" in the subclass method.
	}
}

class X{
	public int x;

	public static final int CONST = 0;

	public int method(){
		System.out.println("Class X method 1");
		return 1;
	}

	public int method(String str){
		System.out.println("Class X method 2, String: " + str);
		return 1;
	}

	public int method(int integer){
		System.out.println("Class X method 3, int: " + integer);
		return 1;
	}

	public int method4(){
		System.out.println("Class X method 4");
		return 0;
	}

}

class Y extends X implements testInterface{
	public int y;
	
/*	
	//II(a)
	public int method(){
		System.out.println("Class Y method");
		return 1;
	}
*/
	
/*	
	//II(b)
	public void method(){
		System.out.println("Class Y method 2, different return type");
	}
*/

/*	
	//II(c)
	public int method(int i){
		System.out.println("Class Y method 3, different parameter type");
		return 1;
	}
*/	

/*	
	//II(d)
	public int method(int lolwut){
		System.out.println("Class Y method 4, different parameter name");
		return lolwut;
	}
*/	

/*	
	//III(b) and III(c)
	public void main(){
		System.out.println("main method: static final int: " + X.CONST);
	}
*/

/*
	//IV
	public int method4(){
		//super.method4();
		System.out.println("Class Y method 4");
		return 0;
	}
*/
}

interface testInterface{
	
	//II(a)
	//public int method();

	//II(b)
	//public void method();

	//II(c)
	//public int method(int i);

	//II(d)
	//public int method(int lolwut);

	public static final int CONST = 0;
}