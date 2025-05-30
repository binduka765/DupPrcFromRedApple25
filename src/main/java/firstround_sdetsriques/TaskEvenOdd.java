package firstround_sdetsriques;

public class TaskEvenOdd implements Runnable {
	
	 private int max;
	    private Printer print;
	    private boolean isEvenNumber;
	    TaskEvenOdd(Printer print, int max, boolean isEvenNumber) {
	        this.print = print;
	        this.max = max;
	        this.isEvenNumber = isEvenNumber;
	}
	    @Override
	    public void run() {
	        int number = isEvenNumber == true ? 2 : 1;
	        while (number <= max) {
	            if (isEvenNumber) {
	                //System.out.println("Thread Even: "+ Thread.currentThread().getName
	                print.printEven(number);
	            } else {
	                //System.out.println("Thread Odd: "+ Thread.currentThread().getName
	                print.printOdd(number);
	            }
	number += 2; 
	}
	} 
	    }
	class Printer {
	    boolean isOdd = false;
	    synchronized void printEven(int number) {
	        while (isOdd == false) {
	            try {
	                wait();
	            } catch (InterruptedException e) {
	            	  e.printStackTrace();
	            }
	        }
	        System.out.println("Thread Even: " + number);
	        isOdd = false;
	        notifyAll();
	}
	    synchronized void printOdd(int number) {
	        while (isOdd == true) {
	try { wait();
	            } catch (InterruptedException e) {
	                e.printStackTrace();
	} }
	        System.out.println("Thread Odd: " + number);
	        isOdd = true;
	        notifyAll();
	}
	    
	    

}
