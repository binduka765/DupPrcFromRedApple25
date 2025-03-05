package faqs102feb2025;

public class SwapWithoutThirdVar08 {

	public static void main(String[] args) {
		
		int x = 5;
		int y = 10;
		
		//with using third var: temp
		int t;
		t = x;
		x = y;
		y = t;
		
		
		//without using the third: temp var: using + operator
		x = x+y;
		y = x-y;
		x = x-y;
		
		//3.without using the third: using * operator 
		y = x * y;
		y = x/y;
		x = x/y;
		
		//4.using XOR: ^ => bitwise conversion
		x = x^y;
		y = x^y;
		x = x^y;
		
		
		System.out.println(x);
		System.out.println(y);

	}

}
