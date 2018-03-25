import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

public class Square extends GameObject {
	boolean isAlive = true;
	boolean goingUp = false;
	public boolean left = false;
	public boolean right = false;

	int xlVelocity = 5;
	int xrVelocity = 5;
	int tempX;
	int tempY;
	int gravity = 2;
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
		x = tempX;
		y = tempY;
	}

	public void jump() {
		if (!squareCollision) {
			if (canJump) {
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
			x -= 10;
		}
		if (tempX < 0) {
			x += 10;
		}
		if (squareCollision) {
			yVelocty = 0;
			tempY -= yVelocty;
			System.out.println("Collision");
			yVelocty -= gravity;
			canJump = true;

		}
		if (left) {
			tempX = x - 10;

		}
		if (right) {
			tempX = x + 10;
			System.out.println(tempX);
		}

		yVelocty += gravity;
		tempY += yVelocty;
		if (yVelocty == 0) {
			goingUp = false;
		}
		if (tempY >= yLimit) {
			tempY = yLimit;
			yVelocty = 0;
			canJump = true;
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
