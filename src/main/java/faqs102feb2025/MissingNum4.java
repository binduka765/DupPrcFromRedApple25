package faqs102feb2025;

public class MissingNum4 {

	public static void main(String[] args) {
		int a[] = {1, 2, 4, 5};
		
		//using simple mathematics-adding all nums
		//chk for boundary values as well, include negative ints and chk
		
		int sum = 0;
		
		for(int i=0;i<a.length;i++) {//adding only the array values
			sum = sum + a[i];
		}
		System.out.println(sum);
		
		int sum1 = 0;
		for(int j=0;j<=5;j++) {//sequence addition
			sum1 = sum1 + j;
		}
		System.out.println(sum1);
		
		System.out.println("missing num : "+(sum1 - sum));

	}
  
}
