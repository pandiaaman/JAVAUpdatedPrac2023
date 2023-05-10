package f_ThreadsMultiThreading;
/*
 * synchronized keyword is used with methods that can be accessed by one or more threads at a given time
 * it makes the process synchronous, i.e., multiple threads can make changes at a given time
 * capability to control the access of multiple threads to any shared resource.
 */

class Machine{
	String name;
	int rpm;
	String mode;
	
	public Machine(String name, int rpm, String mode) {
		this.name = name;
		this.rpm = rpm;
		this.mode = mode;
	}
	
	 synchronized void work(int n, int sleep) {
		for(int i=0;i<10;i++) {
			System.out.println("value for " + Thread.currentThread().getName() + " is " + i*n);
			try {
				Thread.sleep(sleep);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

class MyThreadMachine implements Runnable{
	Machine m;
	int n;
	int sleep;
	
	public MyThreadMachine(Machine m, int n, int sleep) {
		this.m = m;
		this.n = n;
		this.sleep = sleep;
	}
	@Override
	public void run() {
		m.work(this.n,this.sleep);
	}
}

public class ThreadImplementation2withSynchronized {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Machine m1 = new Machine("machine1",100,"on");
//		Machine m2 = new Machine("machine2",200,"on");
		
		//synchronized works when we are using multiple threads to access same reosource of SAME object
		//only one thread can act on a synchronized block at a given time
		//Synchronized block is used to lock an object for any shared resource.
		
		MyThreadMachine t1 = new MyThreadMachine(m1,10,1500);
		MyThreadMachine t2 = new MyThreadMachine(m1,20,1000);	
		
		Thread p1 = new Thread(t1);
		Thread p2 = new Thread(t2);
		
		p1.start();
		p2.start();
	}

}
