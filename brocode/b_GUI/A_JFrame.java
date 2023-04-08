package b_GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class A_JFrame {

	public static void main(String[] args) {
	/*
		// JFrame : a GUI window to add components to
		JFrame frame = new JFrame();
		
		//sets the x and y dimensions of our frame
		frame.setSize(420,420);
		
		//setting title of frame
		frame.setTitle("JFrame INTRO title");
		
		//hitting the X on the frame without below line will only hide the frame and not close the program
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //now the program exits as we close the jframe
//		JFrame.HIDE_ON_CLOSE  //by default
		
		//if we dont want to allow user to resize the window
//		frame.setResizable(false); //prevents from resizing
		
		//image icon
		ImageIcon icon = new ImageIcon("codeBytes.jpg");
		frame.setIconImage(icon.getImage());
		
		//frame needs to be set to visible
		frame.setVisible(true);
		
		//changing the background color of frame
		frame.getContentPane().setBackground(Color.green); // pre defined colors
		frame.getContentPane().setBackground(new Color(0,0,0)); // RGB colors
		frame.getContentPane().setBackground(new Color(125,195,240));
		frame.getContentPane().setBackground(new Color(0x123456));// hexadecimal using 0x
		*/
		
		//calling the MyFrame object for creating a JFrame
		A_MyFrame myFrame = new A_MyFrame();
	
		
		
	}

}
