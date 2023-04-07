package e_interfaces;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Comparator;

import basics.Student;

public class A_InterfaceBasics {

	public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
		
		Student s1 = new Student(2,"aman");
		//cloneable
		Student sclone = (Student) s1.clone();
		System.out.println(sclone.getName());

		//serializable
		FileOutputStream fos = new FileOutputStream("xyz.txt");
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		oos.writeObject(sclone);
		
		//deserialize
		FileInputStream fis = new FileInputStream("xyz.txt");
		ObjectInputStream ois = new ObjectInputStream(fis);
		Student scloneDeserialized = (Student) ois.readObject();
	}

}

