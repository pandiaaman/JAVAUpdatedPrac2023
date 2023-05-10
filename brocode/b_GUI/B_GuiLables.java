package b_GUI;

import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.border.Border;

public class B_GuiLables {

	public static void main(String[] args) {
		//creating base frame
		JFrame frame = new JFrame();
		frame.setVisible(true);
		frame.setSize(420,420);
		frame.setTitle("learning labels");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setBackground(new Color(0x123456));
		//without the below code line, the label takes all the space in the frame, to stop this we can set the layout of frame to null and separately define the bounds of the label
		//frame.setLayout(null);
		
		
		//creating a label
		JLabel label = new JLabel();
		//setting text of the label
		label.setText("hi there, do you like to code?");
		label.setForeground(new Color(0xFFFFFF));
		

		//creating an image icon
		ImageIcon image = 	new ImageIcon("download.jpeg");
		label.setIcon(image);
		
		//aligning the label wrt the frame and the imageicon
		label.setHorizontalTextPosition(JLabel.CENTER); //LEFT, CENTER, RIGHT wrt image icon
		label.setVerticalTextPosition(JLabel.TOP); //sets image TOP, CENTER, BOTTOM wrt image icon
		//setting font for the label
		label.setFont(new Font("MV Boli",Font.PLAIN,20));
		//set background color to label
		label.setBackground(Color.black);
		label.setOpaque(true);//color changes after this property 

		//set the gap of image to text
		label.setIconTextGap(1);//pretty close //overlaps if -ve
		
		
		//adding our label to the frame
		frame.add(label);
		

		//creating a border width
		Border border = BorderFactory.createLineBorder(Color.green, 3); //you will see that label likes to take all the space in the frame
		label.setBorder(border);
		
		//if we want to set the positioning of the elements inside the label
		label.setVerticalAlignment(JLabel.BOTTOM);
		label.setHorizontalAlignment(JLabel.RIGHT);
		
		//setting bounds here because we set the layout of the frame as null
		//label.setBounds(0,0,250,300);
		
		//pack method : adjusts the size of the frame in a way it accomodates all the elements
		frame.pack(); //should be used at the end of adding all other elements in the frame 
	}
	
}
