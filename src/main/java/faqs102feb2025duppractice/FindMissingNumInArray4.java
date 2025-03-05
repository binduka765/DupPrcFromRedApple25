package faqs102feb2025duppractice;

public class FindMissingNumInArray4 {

	public static void main(String[] args) {
		int num[] = {1, 2, 3, 5, 6};
		
		//1.using mathematical addition - sum of all eles of array
		int sum = 0;
		
		for(int i=0;i<num.length;i++) {
			sum = sum + num[i];
		}
		System.out.println("addition of integers of array: "+sum);
		
		//sequential addition of integers(includes missing no.s) in array:
		int sum1 = 0;
		for(int j=0;j<num.length;j++) {
			sum1 = sum1 + j;
		}
		
		System.out.println(sum1);
		
        System.out.println("missing num : "+(sum - sum1));
	}

}
