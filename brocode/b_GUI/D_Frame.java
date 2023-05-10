package b_GUI;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class D_Frame extends JFrame implements ActionListener{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	JButton button;
	JButton buttonUsingLambda;
	
	D_Frame(){
		
		button = new JButton();
		button.setText("click me");
		button.setBackground(Color.red);
		button.setBounds(0, 0, 100, 30);
		button.setFocusable(false); //removes the border around the text in button
		button.addActionListener(this); //helps in connecting the event listener to 
		
		
		buttonUsingLambda = new JButton();
		buttonUsingLambda.setText("click me too");
		buttonUsingLambda.setBounds(200,0,300,100);
		buttonUsingLambda.setFocusable(false);
		buttonUsingLambda.addActionListener((e)->{
			if(e.getSource() == buttonUsingLambda) {
				System.out.println("poop from Lambda man"); //prints on clicking of button
			}
		});
		
		
		//attaching an icon inside the button
		ImageIcon icon = new ImageIcon("thumbsup.png");
		buttonUsingLambda.setIcon(icon);
		
		this.setSize(750,750);
		this.setLayout(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		this.add(button);
		this.add(buttonUsingLambda);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == button) {
			System.out.println("poo"); //prints on clicking of button
		}
		
	}
}
