package b_GUI;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class C_JavaPanels {

	public static void main(String[] args) {
		
		ImageIcon icon = new ImageIcon("thumbsup.png");
		
		JLabel label = new JLabel();
		label.setText("hello there");
		label.setIcon(icon);
		label.setVerticalAlignment(JLabel.BOTTOM);
		
		//JPanel is a GUI component that is used as a container to hold other components
		JPanel redPanel = new JPanel();
		redPanel.setBackground(Color.red);
		//since the frame below has layout as null, we need to set the bounds of all elements that are used on it
		redPanel.setBounds(0,0,250,250);
		redPanel.setLayout(new BorderLayout());
		
		JPanel bluePanel = new JPanel();
		bluePanel.setBackground(Color.BLUE);
		//since the frame below has layout as null, we need to set the bounds of all elements that are used on it
		bluePanel.setBounds(0,0,450,450);
		
		JPanel greenPanel = new JPanel();
		greenPanel.setBackground(Color.green);
		//since the frame below has layout as null, we need to set the bounds of all elements that are used on it
		greenPanel.setBounds(450,0,250,250);
		
		
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(750,750);
		frame.setLayout(null);
		frame.setVisible(true);
		
		//adding the label with icon to the redPanel
		redPanel.add(label);
		
		frame.add(redPanel);
		frame.add(bluePanel);
		frame.add(greenPanel);
	}

}
