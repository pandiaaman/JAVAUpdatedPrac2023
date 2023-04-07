package basics;

import java.io.Serializable;
import java.util.Comparator;



public class Student implements Cloneable, Serializable{
	/**
	 * Serializable version id
	 */
	private static final long serialVersionUID = 1L;
	
	
	private int rollno;
	private String name;
	private static String schoolName = "DAV";
	
	public Student(int rollno, String name) {
		this.rollno = rollno;
		this.name = name;
	}
	
	public String toString() {
		return ("for " + this.name + " roll no is " + this.rollno);
	}

	public int getRollno() {
		return rollno;
	}

	public void setRollno(int rollno) {
		this.rollno = rollno;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	
}

class CompareRollNo implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getRollno()-o2.getRollno();
	}
	
}

class CompareName implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		return o1.getName().compareTo(o2.getName());
	}
	
}

class CompareNameAndRollNo implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		int nameCompare = o1.getName().compareTo(o2.getName());
		int rollNoCompare = o1.getRollno()-o2.getRollno();
		return (nameCompare==0)?rollNoCompare:0;
	}
	
}
