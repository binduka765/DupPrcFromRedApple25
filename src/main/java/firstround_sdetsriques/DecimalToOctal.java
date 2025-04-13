package firstround_sdetsriques;

import java.util.Scanner;

public class DecimalToOctal {
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter The Decimal Number: ");
        int inputNumber = sc.nextInt();
        int copyOfInputNumber = inputNumber;
        String octal = "";
        int rem = 0;
        while (inputNumber > 0) {
            rem = inputNumber % 8;
            octal =  rem + octal;
            inputNumber = inputNumber / 8;
        }
        System.out.println("Octal Equivalent of "+copyOfInputNumber+" is "+octal);

}
}
