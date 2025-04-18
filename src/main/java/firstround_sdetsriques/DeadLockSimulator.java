package firstround_sdetsriques;
//Explain deadlock condition in-between two threads with example?
public class DeadLockSimulator {
	
	 public static Object Lock1 = new Object();
	    public static Object Lock2 = new Object();
	    private static class FirstThread extends Thread {
	        public void run() {
	            synchronized (Lock1) {
	            System.out.println("Thread 1: Holding lock 1...");
	            try { Thread.sleep(10); } catch (Exception e) {}
	            System.out.println("Thread 1: Waiting for lock 2...");
	            synchronized (Lock2) {
	                System.out.println("Thread 1: Holding lock 1 & 2...");
	            }
	} }
	}
	    private static class SecondThread extends Thread {
	        public void run() {
	            synchronized (Lock2) {
	            System.out.println("Thread 2: Holding lock 2...");
	            try { Thread.sleep(10); } catch (Exception e) {}
	            System.out.println("Thread 2: Waiting for lock 1...");
	            synchronized (Lock1) {
	                System.out.println("Thread 2: Holding lock 1 & 2...");
	            }
	} }
	    }
	    public static void main(String args[]) {
	        new FirstThread().start();
	        new SecondThread().start();
	    }

}
