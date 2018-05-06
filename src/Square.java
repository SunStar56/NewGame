import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.Objects;

public class Square extends GameObject {
	boolean isAlive = true;
	boolean goingUp = false;
	public boolean left = false;
	public boolean right = false;
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
	//Key : Coming From the...
	//* 1 : Left
	//* 2 : Right
	//* 3 : Bottom
	//* 4 : Top

	public Square(int x, int y, int width, int height) {
		super(x, y, width, height);
		x = tempX;
		y = tempY;
	}
	public int getY() {
		return y;
	}
	public void jump() {
		//if (!squareCollision) {
			
		//}
	}
	public void moveLeft(int speed) {
		tempX = x - speed;
	}
	public void moveRight(int speed) {
		tempX = x + speed;
	}

	public void update() {
		super.update();
		collisionBox.setBounds(tempX, tempY, Square.size, Square.size);
		if (!squareCollision) {
			System.out.println("not colliding");
			x = tempX;
			y = tempY;
		} else {
			squareCollision = true;
		}

		if (tempX > 750) {
			x -= 10;
		}
		if (tempX < 0) {
			x += 10;
		}
		if (squareCollision) {
			System.out.println("colliding");
			tempY += yVelocty;
			System.out.println(tempY);
			squareCollision = false;
			
		}else {
			if (left) {
				tempX = x - 5;
			}
			if (right) {
				tempX = x + 5;
			}
		}

		yVelocty += gravity;
		//if (!squareCollision) {
			tempY += yVelocty;
	//	}
		if (yVelocty == 0) {
			goingUp = false;
		}

	}

	public void draw(Graphics g, Color c) {
		Graphics2D g2 = (Graphics2D) g;
		g.setColor(c);
		g.fillRect(x, y, width, height);
		//System.out.println(x + " :x y: " + y);
		g2.setColor(Color.BLUE);
		g2.draw(collisionBox);
	}

}
