import java.awt.Color;
import java.awt.Graphics;

public class Square extends GameObject {
	boolean isAlive = true;
	boolean goingUp = false;
	public boolean left = false;
	public boolean right = false;

	int xlVelocity = 5;
	int xrVelocity = 5;
	int gravity = 1;
	int yVelocty = 0;
	int xVelocty = 0;
	static int size = 50;
	int jumpPower = 20;

	int yLimit = 500;

	boolean canJump = true;
	boolean canMoveL = true;
	boolean canMoveR = true;

	public Square(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void jump() {
		if (canJump) {
			goingUp = true;
			yVelocty -= jumpPower;
			canJump = false;
		}
	}

	public void update() {
		super.update();
		if (x < 50) {
			canMoveL = false;
			System.out.println(x + " " + y);
		}
		if (x > 750) {
			canMoveR = false;
			System.out.println(x + " " + y);
		}
		if (left) {
			x -= xlVelocity;
		}
		if (right) {
			x += xrVelocity;
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
		}

	}

	public void draw(Graphics g, Color c) {
		g.setColor(c);
		g.fillRect(x, y, width, height);

	}
}
