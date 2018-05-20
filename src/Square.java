import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Square extends GameObject {
	boolean isAlive = true;
	boolean goingUp = false;
	int tempX;
	int tempY;
	int gravity = 2;
	int yVelocty = 0;
	static int size = 50;
	int jumpPower = 20;
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
		if (!canJump) {
			goingUp = true;
			tempY -= (jumpPower + yVelocty);
			yVelocty += 1;
			System.out.println(yVelocty);

			canJump = false;
		} else {
		}
	}

	public void moveLeft(int speed) {
		tempX = x - speed;
		System.out.println("Called moveLeft");
	}

	public void moveRight(int speed) {
		tempX = x + speed;
		System.out.println("Called moveRight");
	}

	public void update() {
		super.update();
		collisionBox.setBounds(tempX, tempY += gravity, Square.size, Square.size);

		if (tempX > 750) {
			x -= 10;
		}
		if (tempX < 0) {
			x += 10;
		}
		if (squareCollision) {
			squareCollision = true;
			canJump = true;
			System.out.println("colliding");

			// System.out.println(tempY);
			// squareCollision = false;

		} else {
			yVelocty = 0;
			x = (int) collisionBox.getX();
			y = (int) collisionBox.getY();
			// tempY = tempY - yVelocty;
			// System.out.println("not colliding");
			yVelocty += gravity;
			// if (!squareCollision) {
			tempY += yVelocty;
		}

		// }
		if (yVelocty == 0) {
			goingUp = false;
		}

		tempX = x;
		tempY = y;
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
