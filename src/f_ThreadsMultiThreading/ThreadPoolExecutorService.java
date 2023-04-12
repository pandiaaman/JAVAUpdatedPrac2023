package f_ThreadsMultiThreading;

import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ThreadPoolExecutorService {

	public static void main(String[] args) {
		/*
		 * suppose you have 1000 tasks to complete
		 * creating 1000 threads would be a waste of resource, since a thread after creation can only do one task and will be of
		 * no use further
		 * so we want our limited no of threads to share the tasks between them and let the same thread pick the next
		 * task once the current task finishes
		 * this will need a pool where we can keep the threads with us to run the tasks
		 * we use executorService to create a thread pool
		 * 
		 * in java, one thread corresponds to one OS thread
		 */

		//creating a pool of 5 threads to take care of a multiple tasks
		ExecutorService servicePool = Executors.newFixedThreadPool(5);
		
		for(int i=0;i<10;i++) {
			servicePool.execute(new Runnable() {
				@Override
				public void run() {
					for(int i=0;i < 10; i++) {
						System.out.println("PART 1 : thread " + Thread.currentThread().getName() + " running for the loop " + i);
						try {
							Thread.sleep(new Random().nextInt(2000)+1000);
						}catch(InterruptedException e) {
							e.printStackTrace();
						}catch(Exception e) {
							e.printStackTrace();
						}
					}
				}
			});
			
			servicePool.execute(()->{
				System.out.println("PART2 : thread " + Thread.currentThread().getName() + " running");
			});
			
		}
		
		
		/*
		 * for a cpu intensive task, since java thread equals one OS thread, we need to make sure that we use correct
		 * number of threads in pool
		 * 
		 * one way to do this, is to check the no of available cores
		 * and pass this no to the ExecutorService to create threads in a pool
		 */
		int coreCount = Runtime.getRuntime().availableProcessors();
		ExecutorService servicePoolForCPUIntensiveTasks = Executors.newFixedThreadPool(coreCount);
		
		/*
		 * lets say we have some IO intensive operations, like getting data from DB
		 * or to call http url and get data from there or any network calls
		 * 
		 * in this case, its better to have the size of the pool as large one, so that while few threads
		 * are waiting for the service to return the data the other threads can continue to work
		 */
		
		
		//CachedThreadPool
		/*
		 * in case of dynamic no of tasks coming in the application, we can not rely on fixed no of threads
		 * hence in this case, we can not depend on the Executors.newFiexedThreadPool and instead we need dynamic
		 * 
		 * suppose we have 1000 tasks and 5 threads to work with then we might need more threads if all current ones
		 * are occupied, then we need to use cachedThreadPool
		 */
		ExecutorService servicePoolCachedThreads = Executors.newCachedThreadPool();
		
		//ScheduledThreadPool
		/*
		 * there can be scenarios where we want the task to be completed after a certain delay, 
		 * lets say we want to do some security checks like login checks after every 20 secs, then we can use this
		 * 
		 * checks for every 10 secs can be done using scheduledAtFixedRate
		 * we use service.schedule instead of execute
		 */
		
		ScheduledExecutorService schedulingServicePool = Executors.newScheduledThreadPool(10);
		//task to run at every 10 sec delay
		schedulingServicePool.schedule(new Runnable() {

			@Override
			public void run() {
				System.out.println("this is a scheduled task to run after every 10 secs");
				
			}
			
		}, 10, TimeUnit.SECONDS); //second and third parameter is time of delay and units
		
	}

}
