package f_ThreadsMultiThreading;

/*
 * Thread.sleep() throws the interrupted exception for the given milisecs mentioned
 * 
 * yield vs suspend vs interrupt
 */
class MyThread3 implements Runnable{
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println(i);
			try {
				Thread.sleep(1000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThread4 implements Runnable{
	@Override
	public void run() {
		for(int i=10;i>0;i--) {
			System.out.println(i);
			try {
				Thread.sleep(2000);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}


public class ThreadImplementation1withSleep {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		long startTime = System.currentTimeMillis();
		
		/*
		 * we can use get name and currentThread() methods to get the current running thread
		 */
		Thread currThread = Thread.currentThread();
		System.out.println(currThread.getName());
		System.out.println(currThread.getId());
		
		
		MyThread3 p = new MyThread3();
		MyThread4 q = new MyThread4();
		
		Thread t1 = new Thread(p);
		Thread t2 = new Thread(q);
		

		System.out.println("state of the thread " + t1.getName() + " is " + t1.getState() + " with priority : " + t1.getPriority()); //NEW state
		System.out.println("state of the thread " + t2.getName() + " is " + t2.getState() + " with priority : " + t2.getPriority());
		System.out.println("state of the thread " + currThread.getName() + " is " + currThread.getState() + " with priority : " + currThread.getPriority());
		
//		t1.run(); //these methods run the threads separately, we need to use the start() method for threads to work together
//		t2.run();
		
		//use start method for threads to work together
		t1.start();
		t2.start();

		System.out.println("state of the thread " + t1.getName() + " is " + t1.getState() + " with priority : " + t1.getPriority()); //RUNNABLE state
		System.out.println("state of the thread " + t2.getName() + " is " + t2.getState() + " with priority : " + t2.getPriority());
		System.out.println("state of the thread " + currThread.getName() + " is " + currThread.getState() + " with priority : " + currThread.getPriority());
		/*
		 * here we have three threads running now, t1, t2 and main, lets see which one it prints
		 */
		Thread currThread2 = Thread.currentThread();
		System.out.println(currThread2.getName()); //prints main
		System.out.println(currThread.getId()); //prints 1
		
		/*
		 * threads work separately from each other
		 * the main thread will keep running while the other threads are running too
		 * so the code after the threads 1 and 2, will also run while the threads are running
		 * to wait for the current threads to complete running and then continue the furhter program(main thread), 
		 * we can use join method
		 */
		try {
			t1.join();
			t2.join();	
			System.out.println("state of the thread " + t1.getName() + " is " + t1.getState() + " with priority : " + t1.getPriority()); //TERMINATED state
			System.out.println("state of the thread " + t2.getName() + " is " + t2.getState() + " with priority : " + t2.getPriority());
			System.out.println("state of the thread " + currThread.getName() + " is " + currThread.getState() + " with priority : " + currThread.getPriority());
		}catch(InterruptedException e) {
			e.printStackTrace();
		}

		System.out.println("further code");
		
		long endTime = System.currentTimeMillis();
		System.out.println("time taken : " + (endTime-startTime));
	}

}
