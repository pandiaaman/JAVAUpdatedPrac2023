package b_GUI;

import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

public class A_MyFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public A_MyFrame(){
		// JFrame : a GUI window to add components to
			//	JFrame this = new JFrame(); we dont need to create an object in the child class 
				
				//sets the x and y dimensions of our this
				this.setSize(420,420);
				
				//setting title of this
				this.setTitle("JFrame INTRO title");
				
				//hitting the X on the this without below line will only hide the this and not close the program
				this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); //now the program exits as we close the jframe
//				JFrame.HIDE_ON_CLOSE  //by default
				
				//if we dont want to allow user to resize the window
//				this.setResizable(false); //prevents from resizing
				
				//image icon
				ImageIcon icon = new ImageIcon("codeBytes.jpg");
				this.setIconImage(icon.getImage());
				
				//this needs to be set to visible
				this.setVisible(true);
				
				//changing the background color of this
				this.getContentPane().setBackground(Color.green); // pre defined colors
				this.getContentPane().setBackground(new Color(0,0,0)); // RGB colors
				this.getContentPane().setBackground(new Color(125,195,240));
				this.getContentPane().setBackground(new Color(0x123456));// hexadecimal using 0x
	}
}
