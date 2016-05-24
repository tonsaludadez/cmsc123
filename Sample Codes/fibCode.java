/*
	Daghan sayup ani nga code. Kill.
*/

public class fibCode{

	public static int fibonacci(int a){
		if(a == 1){
			return 1;
		}

		if(a == 2){
			return 1;
		}

		else
			return fibonacci(a-1) + fibonacci(a-2);
	}

	public static void main(String[] args) {
		/*int a = fibCode.fibonacci();
		System.out.println(a);*/

		for(int i = 1 ; i < 30 ; i++){
			System.out.println(fibCode.fibonacci(i));
		}

	}	
}