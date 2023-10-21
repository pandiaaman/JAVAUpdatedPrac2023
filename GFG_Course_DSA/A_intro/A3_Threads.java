package A_intro;

class ThreadOne implements Runnable{
	
	@Override
	public void run() {
		System.out.println("running thread one" + Thread.currentThread().getName());
		
		for(int i=0;i<5;i++) {
			try {
				System.out.println(i);
				Thread.sleep(500);
			}catch(InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		
	}
}



public class A3_Threads {

	public static void main(String[] args) {
		
		Thread t1 = new Thread(new ThreadOne());
		
		Thread t2 = new Thread(()->{
			System.out.println("running lambda thread "  + Thread.currentThread().getName());
			for(int i=10;i<15;i++) {
				try {
					System.out.println(i);
					Thread.sleep(300);
				}catch(InterruptedException e) {
					e.printStackTrace();
				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		}catch(InterruptedException e) {
			e.printStackTrace();
		}
		
		
		
		System.out.println("complete " + Thread.currentThread().getName());
	} 
	
}
