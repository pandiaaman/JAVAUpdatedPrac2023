package f_ThreadsMultiThreading;

class Table{  
	 public void printTable(int n){//synchronized method  
	   for(int i=1;i<=5;i++){  
	     System.out.println(n*i);  
	     try{  
	      Thread.sleep(400);  
	     }catch(Exception e){System.out.println(e);}  
	   }  
	  
	   synchronized(this) {
		   for(int i=1;i<=10;i++){  
			     System.out.println("synchronized block : " + n*i);  
			     try{  
			      Thread.sleep(400);  
			     }catch(Exception e){System.out.println(e);}  
			   }  
	   }
	 }  
	}  
	  
	class MyThread6 extends Thread{  
	Table t;  
	MyThread6(Table t){  
	this.t=t;  
	}  
	public void run(){  
	t.printTable(5);  
	}  
	  
	}  
	class MyThread7 extends Thread{  
	Table t;  
	MyThread7(Table t){  
	this.t=t;  
	}  
	public void run(){  
	t.printTable(100);  
	}  
	}  

	
public class ThreadImplementation3withSynchronized {
	public static void main(String args[]){  
		Table obj = new Table();//only one object  
		MyThread6 t1=new MyThread6(obj);  
		MyThread7 t2=new MyThread7(obj);  
		t1.start();  
		t2.start();  
		}  
}
