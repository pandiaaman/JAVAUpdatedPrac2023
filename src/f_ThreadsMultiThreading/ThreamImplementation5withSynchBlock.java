package f_ThreadsMultiThreading;

class MachineTwo{
	String name;
	int rpm;
	
	public MachineTwo(String name, int rpm) {
		this.name = name;
		this.rpm = rpm;
	}
	
	public String toString() {
		return ("machine " + this.name + " has : " + this.rpm + " rpm");
	}
	
	public void startMachineTwo() {
		synchronized(this) {
			for(int i=0;i<10;i++) {
				System.out.println(Thread.currentThread().getName() + " method part : SYNCH : " + this.rpm*i*10);
				try {
					Thread.sleep(1000);
				}catch(InterruptedException | IllegalThreadStateException e) {
					e.printStackTrace();
				}
			}
		}
		
		for(int i=0;i<8;i++) {
			System.out.println(Thread.currentThread().getName() + " method part normal : " + this.rpm*i*100);
			try {
				Thread.sleep(1500);
			}catch(InterruptedException | IllegalThreadStateException e) {
				e.printStackTrace();
			}
		}
	}
}


 
public class ThreamImplementation5withSynchBlock {

	public static void main(String[] args) {
		/*
		 * one thread one machine
		 * one thread two machine
		 * two thread two machine
		 */
		long startTime = System.currentTimeMillis();
		
		MachineTwo m1 = new MachineTwo("machine One", 10);
		MachineTwo m2 = new MachineTwo("machine Two", 10);
		
		new Thread(()-> {
			System.out.println("thread assigned : " + Thread.currentThread().getName() + " with id : " + Thread.currentThread().getId());
			m1.startMachineTwo();
		}).start();
		
		new Thread(()-> {
			System.out.println("thread assigned : " + Thread.currentThread().getName() + " with id : " + Thread.currentThread().getId());
			m2.startMachineTwo();
		}).start();
		
		
		long endTime = System.currentTimeMillis();
		System.out.println("time taken : " + (endTime - startTime));
		
	}

}
