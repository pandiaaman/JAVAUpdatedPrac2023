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
		
		//creating a label
		JLabel label = new JLabel();
		//setting text of the label
		label.setText("hi there, do you like to code?");
		label.setForeground(new Color(0xFFFFFF));
		
		//aligning the label wrt the frame and the imageicon
		label.setHorizontalTextPosition(JLabel.CENTER); //LEFT, CENTER, RIGHT
		label.setVerticalTextPosition(JLabel.CENTER); //sets image TOP, CENTER, BOTTOM wrt image icon
		//setting font for the label
		label.setFont(new Font("MV Boli",Font.PLAIN,20));
		//set background color to label
		label.setBackground(Color.black);
		label.setOpaque(true);//color changes after this property 

		
		//adding our label to the frame
		frame.add(label);
		
		
		//creating an image icon
		ImageIcon image = 	new ImageIcon("download.jpeg");
		label.setIcon(image);
		
		//creating a border width
		Border border = BorderFactory.createLineBorder(Color.green, 3);
		
		label.setBorder(border);
		label.setVerticalAlignment(JLabel.TOP);
	}
	
}
