package firstround_sdetsriques;

public class ElementLeaderTest {
	
	void printLeaders(int arr[], int size) {
        for (int i = 0; i < size; i++) {
            int j;
            for (j = i + 1; j < size; j++) {
                if (arr[i] <= arr[j])
                    break;
            }
            if (j == size) // the loop didn't break
                System.out.print(arr[i] + " ");
} }
    public static void main(String[] args) {
    	ElementLeaderTest lead = new ElementLeaderTest();
        int arr[] = new int[]{25, 10, 2, 4, 1, 3};
        int n = arr.length;
        lead.printLeaders(arr, n);
}

}
