package basics;

public class VolatilePrac {
	volatile int t = 10;
	public static void main(String[] args) {
		
		VolatilePrac obj = new VolatilePrac();
		
		Thread t1 = new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i=0;i<5;i++) {
					
					obj.t++;
					System.out.println(Thread.currentThread().getName() + " affecting var :" + obj.t);
//					try {
//						Thread.sleep(1000);
//					} catch (InterruptedException e) {
//						e.printStackTrace();
//					}
				}
			}
		});
		
		Thread t2 = new Thread(()->{
			for(int i=0;i<4;i++) {
				
				obj.t--;
				System.out.println(Thread.currentThread().getName() + " affecting var :" + obj.t);
//				try {
//					Thread.sleep(1000);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
			}
		});
		
		t1.start();
		t2.start();
		
		try {
			t2.join();
			t1.join();
			
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		System.out.println("final value of t" + obj.t);

	}

}
