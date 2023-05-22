package basics;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.logging.Logger;


class Student implements Serializable{
	private transient int rollno;
	String name;
	
	public Student(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}
	
	public int getRollno() {
		return this.rollno;
	}
	public void setRollno(int rollno) {
		this.rollno  = rollno;
	}
	
	public String getName() {
		return this.name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String toString() {
		return ("Student : [name : " + this.name + "  rollno : " + this.rollno + " ]");
		
	}
	
	
}
public class SerializationTransientPrac {
	
//	private static final Logger LOGGER = MyLoggerFactory.getSimplestLogger();
	
	public static void main(String[] args) {
		
		Student st1 = new Student(5,"stname1");
		Student st2 = new Student(2,"stname2");

		
		
		//serialize the student object
		FileOutputStream fout;
		try {
			
			fout = new FileOutputStream("serialize.txt");
			ObjectOutputStream oout = new ObjectOutputStream(fout);
			oout.writeObject(st1);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	
//		try {
//			Thread.sleep(2000);
//		} catch (InterruptedException e1) {
//			e1.printStackTrace();
//		}
		
		//deserializing
		Student sSer=null;
		
		try {
			FileInputStream fis = new FileInputStream("serialize.txt");
			ObjectInputStream ois = new ObjectInputStream(fis);
			sSer = (Student) ois.readObject();
		}catch(IOException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		
		System.out.println(sSer.getRollno());
		
	}

}
