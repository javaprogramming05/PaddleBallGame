package week4;

import java.awt.Graphics;
import java.awt.event.*;
import javax.swing.*;
public class Controller implements ActionListener, MouseMotionListener {  

	private Ball ball;
	private Paddle paddle;
	private Display display;	
	private Timer timer;

	//constructor
	public Controller (Graphics g) {

		this.paddle = new Paddle();
		this.ball = new Ball();
		this.display = new Display(this);
		this.timer = new Timer(25, this);//Set a Timer
		timer.start();//Start Timer
		display.addMouseMotionListener(this);//Move Paddle with mouse
	}


	//method to check if ball and paddle exist
	public void draw(Graphics g) {
		if (ball != null)
			ball.drawBall(g);
		if (paddle != null)
			paddle.drawPaddle(g);
	}

	//Determine Paddle Position
	public void mouseDragged (MouseEvent e) {
		paddle.changePaddleposition(e.getX() - 35, display.getWidth());
		display.repaint();
	}
	public void mouseMoved (MouseEvent e) {
		paddle.changePaddleposition(e.getX() - 35, display.getWidth());
		display.repaint();
	}

	//Detecting the Ball has contact with Paddle
	public void actionPerformed (ActionEvent e) {
		ball.moveBall(display.getWidth(), display.getHeight());
		ballHitsPaddle();
		display.repaint();
	}


	//method to determine if ball hits paddle
	//if it hits, reverse the direction
	public void ballHitsPaddle () {
		if (ball.getTop() <= paddle.getBottom() && ball.getTop() >= paddle.getBottom() - 5)
			if (ball.getRight() >= paddle.getLeft() && ball.getLeft() <= paddle.getRight())
				ball.reverseYdirection(); //reversing the vertical direction of the ball
	}
}
