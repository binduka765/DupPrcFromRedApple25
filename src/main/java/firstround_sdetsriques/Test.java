package firstround_sdetsriques;

public class Test {
	//multi threading program to print odd no using one thread and even no using
	//another thread
	 static int MAX = 5;
	  public static void main(String... args) {
	        Printer print = new Printer();
	        Thread t1 = new Thread(new TaskEvenOdd(print, MAX, false));
	        Thread t2 = new Thread(new TaskEvenOdd(print, MAX, true));
	        t1.start();
	        t2.start();
	}

}
