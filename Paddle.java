package week4;

import java.awt.Color;
import java.awt.Graphics;

public class Paddle {

	//paddle length
	final int paddleLength;
	
	//X and Y coordinates represent the center of the top surface of the paddle
	private int paddleXcoordinate ;	
	private int paddleYcoordinate;	

	//paddle width
	final int paddleWidth;

	//constructor
	public Paddle() {
		this.paddleLength = 70; //paddle length >= 2(diameter of the ball)
		this.paddleWidth =20;
		this.paddleYcoordinate = 20; //atleast 5% of display height between paddle and top of display area (17.5)
		this.paddleXcoordinate = 120;//initially setting up the paddle position
	}

	
	
	//method to draw paddle
	public void drawPaddle(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(paddleXcoordinate , paddleYcoordinate ,  paddleLength, paddleWidth );
		
	}
	
	
	//methods to return the position of the Top, Bottom, Left and Right edges of the Paddle
	public int getTop() {
		return paddleYcoordinate ;
	}
	
	public int getBottom() {
		return (paddleYcoordinate + paddleWidth);
	}

	public int getLeft() {
		return paddleXcoordinate ;
	}
	
	public int getRight() {
		return (paddleXcoordinate + paddleLength);
	}

	
	//method to change the position of the paddle based on X and Y co-ordinates of the mouse cursor
		public void changePaddleposition(int mousePosition, int width) {
			if (mousePosition < 0)
				paddleXcoordinate = 0;
			else if (mousePosition >= width - 70)
				paddleXcoordinate = width - 70;
			else
				paddleXcoordinate = mousePosition;
		}

	
	
}
