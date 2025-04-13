package firstround_sdetsriques;

//find all pairs of nums whose sum is equal to given num

public class FindPairs {
	
	// Prints number of pairs in arr[0..n-1] with sum equal
    // to 'sum'
    public static void getPairsCount(int[] arr, int sum) {
        // Consider all possible pairs and check their sums
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                if ((arr[i] + arr[j]) == sum) {
                  System.out.printf("(%d, %d) %n", arr[i], arr[j]);
                }
} }
    }
  public static void main(String args[]) {
        int[] arr = { 1, 5, 7, -1, 5 };
        int sum = 12;
        getPairsCount(arr, sum);
}

}
