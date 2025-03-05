package intqs;

public class DuplicateCharsInAWord {

	public static void main(String[] args) {
		
		char country[] = {'C', 'A', 'N', 'A', 'D', 'A'};
		
		for(int i=0;i<=country.length-1;i++) {
			
			if(country[i]==country[i+1]) {
				System.out.println("DUPLICATE FOUND");
			}
		}

}
}