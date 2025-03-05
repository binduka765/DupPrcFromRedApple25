package faqs102feb2025duppractice;

public class ReverseAnInteger3 {

	public static void main(String[] args) {
		
		long num = 12373681;  //18637321
		long rev = 0;
		
		while(num!=0) {
			rev = rev*10 + num%10;
			num = num/10;
		}
       System.out.println(rev);
       
       
       //2nd: way - using StringBuffer
       long l1 = 12373681;
       System.out.println(new StringBuffer(String.valueOf(l1)).reverse());
	}

}
