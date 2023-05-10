package f_ThreadsMultiThreading;


class Customer{
	int balance = 10000;
	
	synchronized public void withdraw(int amount) {
		System.out.println(Thread.currentThread().getName() + "withdrawing ..." + amount);
		if(amount>this.balance) {
			System.out.println("less balance, please deposit");
			try {
				System.out.println(Thread.currentThread().getName() + " waiting for deposit");
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		this.balance-=amount;
		System.out.println(Thread.currentThread().getName() + "withdrawn successfully : " + amount);
		System.out.println(Thread.currentThread().getName() + "your new balance is :" + this.balance);
	}
	
	synchronized public void deposit(int amount) {
		System.out.println(Thread.currentThread().getName() + "depositing..." + amount);
		this.balance += amount;
		System.out.println(Thread.currentThread().getName() + "depositied " + amount);
		System.out.println(Thread.currentThread().getName() + "your balance is now :" + this.balance);
		
		notify();
	}
}

public class InterThreadCommunication {

	/*
	 * aka cooperation
	 * is about allowing synchronized threads to communicate with each other
	 * wait  : causes the current thread to release the lock and wait until either another thread invokes notify or notifyAll method
	 * notify : wakes up a single thread that is waiting on the object's monitor
	 * notify all : wakes up all threads waiting on the object's monitor
	 * 
	 * above three methods work on the locking of object and hence work on the objects 
	 */
	public static void main(String[] args) {
		Customer c = new Customer();
		
		new Thread(()->{
			c.withdraw(40000);
		}).start();
		
		System.out.println("main thread running : " + Thread.currentThread().getName());
		
		Thread tDep = new Thread(()->{
			c.deposit(50000);
		});
		
		try { //simulating that deposit process starts after some time
			tDep.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		tDep.start();
	}

}
