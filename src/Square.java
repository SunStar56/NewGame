import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends GameObject {
	boolean isAlive = true;
	boolean goingUp = false;
	public boolean left = false;
	public boolean right = false;

	int xlVelocity = 5;
	int xrVelocity = 5;
	int tempX;
	int tempY;
	int gravity = 5;
	int yVelocty = 0;
	int xVelocty = 0;
	static int size = 50;
	int jumpPower = 20;
	int yLimit = 500;

	boolean atRest = true;
	boolean squareCollision = false;
	boolean canJump = true;
	boolean canMoveL = true;
	boolean canMoveR = true;

	public Square(int x, int y, int width, int height) {
		super(x, y, width, height);
		tempX = x;
		tempY = 50;
	}

	public void jump() {
		if (!squareCollision) {
			if (canJump) {
				atRest = false;
				goingUp = true;
				yVelocty -= jumpPower;
				canJump = false;
			}
		}
	}

	public void update() {
		super.update();
		collisionBox.setBounds(tempX, tempY, Square.size, Square.size);
		if (squareCollision == false) {
			x = tempX;
			y = tempY;
		} else {
			squareCollision = false;
		}

		if (tempX > 750) {
			tempX -= 5;
		}
		if (tempX < 0) {
			tempX += 5;
		}
		if (squareCollision) {
			// yVelocty = 0;
			// y -= yVelocty;
			System.out.println("Collision");
			yVelocty -= gravity;
			canJump = true;
			atRest = true;

		}
		if (left) {
			tempX = x - 10;

		}
		if (right) {
			tempX = x + 10;
			System.out.println(tempX);
		}

		yVelocty += gravity;
		y += yVelocty;
		if (yVelocty == 0) {
			goingUp = false;
		}
		if (y >= yLimit) {
			y = yLimit;
			yVelocty = 0;
			canJump = true;
			atRest = true;
		}

	}

	public void draw(Graphics g, Color c) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(c);
		g.fillRect(x, y, width, height);
		System.out.println(x + " :x y: " + y);
		g2.setColor(Color.BLUE);
		g2.draw(collisionBox);
	}

}
