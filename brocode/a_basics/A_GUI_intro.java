package a_basics;

import javax.swing.JOptionPane;

public class A_GUI_intro {

	public static void main(String[] args) {
		
		String name = JOptionPane.showInputDialog("enter your name");
		int age = Integer.parseInt(JOptionPane.showInputDialog("enter your age"));
		double heightMeter = Double.parseDouble(JOptionPane.showInputDialog("enter your height in meters"));
		
		JOptionPane.showMessageDialog(null, "hello " + name + " your age is : " + age + " \n and your height is :" + heightMeter );
		
	}

}
