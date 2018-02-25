import java.awt.Color;
import java.awt.Graphics;

public class Square {
	private int x;
	private int y;
	private int width;
	private int height;
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

	public Square(int x, int y, int w, int h) {
		this.x = x;
		this.y = y;
		this.width = w;
		this.height = h;
	}

	public void jump() {
		if (canJump) {
			goingUp = true;
			yVelocty -= jumpPower;
			canJump = false;
		}
	}

	public void update() {
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
