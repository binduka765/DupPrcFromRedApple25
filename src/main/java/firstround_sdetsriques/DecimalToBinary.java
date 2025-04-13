package firstround_sdetsriques;

import java.util.Scanner;

public class DecimalToBinary {
	/*
	 * a program to convert Decimal To Binary, Decimal To Octal and Decimal to 
	 * HexaDecimal in Java?
	 * 
	 */
	
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Decimal Number: ");
        int inputNumber = sc.nextInt();
        int copyOfInputNumber = inputNumber;
        String binary = "";
        int rem = 0;
        while (inputNumber > 0) {
            rem = inputNumber % 2;
            binary =  rem + binary;
            inputNumber = inputNumber/2;
}
        System.out.println("Binary Equivalent of "+copyOfInputNumber+" is "+binary);
    }


}
