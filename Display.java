package week4;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Display extends JPanel {

	private static final long serialVersionUID = 1L;
	
	Controller controller ;

	//overriding paintComponent method
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		g.setColor(Color.white);
		g.fillRect(0, 0, getWidth(), getHeight());
		//passing graphic object to the controller
		controller.draw(g);
	}

	//constructor
	public Display (Controller c) {
		this.controller = c;
		JFrame frame = new JFrame();
		frame.add(this);
		frame.setTitle("Paddle Ball Game");
		frame.setSize(350, 350);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame. EXIT_ON_CLOSE);
	}
}