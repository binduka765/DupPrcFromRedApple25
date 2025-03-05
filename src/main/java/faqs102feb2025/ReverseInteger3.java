package faqs102feb2025;

public class ReverseInteger3 {

	public static void main(String[] args) {
		int num = 12345;
		
		int rev = 0;
		
		while(num!=0) {
			rev = rev * 10 + num%10;
			num = num/10;
		}
        System.out.println("reverse of num: "+rev);
        
        //2nd: way -- using string buffer
        long l1 = 123456;
        System.out.println(new StringBuffer(String.valueOf(l1)).reverse());
	}

}
