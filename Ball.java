/**
 * Description: Paddle ball game implementation
 * 				using timers, mouse events and graphics in Java
 * 

 **/
package week4;

import java.awt.Graphics;
import java.awt.Color;

public class Ball {

	//ball diameter
	private final int diameter;

	//ball position on X co-ordinate
	private int ballXcoordinate;

	//ball position on Y co-ordinate
	private int ballYcoordinate;

	//the distance to move in X and Y directions
	private int moveonXcoordinate;
	private int moveonYcoordinate;

	//constructor
	public Ball() {
		this.diameter = 20;
		//the distance to move will initially be same in X and Y directions
		this.moveonXcoordinate = 5;
		this.moveonYcoordinate = 5;
		this.ballXcoordinate = 10;
		this.ballYcoordinate = 10;
	}

	
	//methods to determine ball position
	public int getTop() {
		return ballYcoordinate;
	}
	
	public int getBottom() {
		return (ballYcoordinate + diameter);
	}

	public int getLeft() {
		return ballXcoordinate;
	}

	public int getRight() {       
		return (ballXcoordinate + diameter);
	}

	//method to draw ball at its current position
	public void drawBall(Graphics g) {
		g.setColor(Color.red);
		g.fillOval(ballXcoordinate , ballYcoordinate , diameter , diameter );
	}

	
	
	//methods to reverse ball on X-direction and Y-direction
	public void reverseXdirection() {
		moveonXcoordinate = - moveonXcoordinate;
	}

	public void reverseYdirection() {
		moveonYcoordinate = - moveonYcoordinate;
	}

	//methods to determine horizontal or vertical center of the ball
	public int ballcenteronX() {
		return ballXcoordinate + (diameter / 2);
	}

	public int ballcenteronY() {
		return ballYcoordinate + (diameter / 2);
	}

	//method to change ball position
	public void moveBall(int length, int height) {
		ballXcoordinate = ballXcoordinate + moveonXcoordinate;
		ballYcoordinate = ballYcoordinate + moveonYcoordinate;

		if (getTop() <= 0)
			reverseYdirection();
		if (getBottom() >= height)
			reverseYdirection();
		if (getLeft() <= 0)
			reverseXdirection();
		if (getRight() >= length)
			reverseXdirection();
	}
}

