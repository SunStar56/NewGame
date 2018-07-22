import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends GameObject {
	boolean isAlive = true;
	boolean goingUp = false;
	boolean moveRight;
	boolean moveLeft;
	boolean touchGoal = false;
	boolean finishLevel = false;
	boolean stuck = false;
	int tempX;
	int tempY;
	int gravity = 2;
	int yVelocty = 0;
	static int size = 50;
	int jumpPower = 100;
	int yLimit = 500;
	boolean atRest = true;
	boolean squareCollision = false;
	int squareCollisionType = 0;
	// Key : Coming From the...
	// * 1 : Left
	// * 2 : Right
	// * 3 : Bottom
	// * 4 : Top
	boolean canJump = true;

	public Square(int x, int y, int width, int height) {
		super(x, y, width, height);
		x = tempX;
		y = tempY;
	}

	public int getY() {
		return y;
	}

	public void jump() {
	
		goingUp = true;
		if (goingUp && canJump) {
			tempY -=jumpPower;
			canJump = false;
			yVelocty +=gravity;
			y+=yVelocty;
		}
		else {
			yVelocty -= gravity;
		}
		if (canJump) {
				goingUp = true;
				yVelocty -=jumpPower;
				canJump=false;
		}
		
		System.out.println(y);	
		if (yVelocty == 0) {
				goingUp = false;
			}
		}
		
	

	public void moveLeft(int speed) {
		tempX = x - speed;
		moveLeft = true;
		moveRight = false;
	}

	public void moveRight(int speed) {
		tempX = x + speed;
		moveRight = true;
		moveLeft = false;
	}

	public void update() {
		collisionBox.setBounds(tempX, tempY += gravity + 2, Square.size, Square.size);

		if (touchGoal) {
			finishLevel = true;
		}
		
		if (squareCollision) {
			if (stuck) {
				y = (int) collisionBox.getY() - 2;
				canJump = true;
			}
			else {
				//yVelocty -= gravity;
				canJump = true;
				x = (int) collisionBox.getX();
			}
			 squareCollision = false;

		} else {
			stuck = false;
			yVelocty = 0;
			x = (int) collisionBox.getX();
			y = (int) collisionBox.getY() - 2;
		}

		// }

		tempX = x;
		tempY = y;
	}

	public void setPos(int newX, int newY) {
		x = newX;
		y = newY;
		
	}
	
	public void draw(Graphics g, Color c) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(c);
		g.fillRect(x, y, width, height);
		// System.out.println(x + " :x y: " + y);
		g2.setColor(Color.BLUE);
		g2.draw(collisionBox);
	}

}
