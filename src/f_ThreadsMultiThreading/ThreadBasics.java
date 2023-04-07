package f_ThreadsMultiThreading;

/*
 * threads can be created by using extends Thread and implements Runnable
 * implements Runnable is better method since we can extend with other classes if required in this scenario
 * each thread is a class
 */

class MyThread1 extends Thread{
	@Override
	public void run() {
		/*
		 * thread task here
		 */
		
		for(int i=0; i<10;i++) {
			System.out.println(i);
		}
	}
}

class MyThread2 implements Runnable{
	@Override
	public void run() {
		/*
		 * when we use Runnable interface, it is a functional interface, with run method, hence it is necessary to use run()
		 */
		for(int i=10; i>0;i--) {
			System.out.println(i);
		}
	}
}

public class ThreadBasics {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		MyThread1 t1 = new MyThread1(); //on extending Thread, we get all the methods required for a thread like wait, notify, run, sleep etc
		
		MyThread2 t = new MyThread2();//no methods will be present for now except run(), since functional interface had only run, we need to create Thread class object
		Thread t2 = new Thread(t); //now we have all the required methods for this too, plus we can extend other classes too for MyThread2 class
		
		t1.start();
		t2.start();
	}

}
