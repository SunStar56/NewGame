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
	int squareCollisionType = 0;
	//Key : Coming From the...
	//* 1 : Left
	//* 2 : Right
	//* 3 : Bottom
	//* 4 : Top
	boolean canJump = true;
	boolean canMoveL = true;
	boolean canMoveR = true;

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
			if (canJump) {
				goingUp = true;
				yVelocty -= jumpPower;
				canJump = false;
			}
		}
	//}

	public void update() {
		super.update();
		collisionBox.setBounds(x, y, Square.size, Square.size);
		if (!squareCollision) {
			System.out.println("not colliding");
			x = tempX;
			y = tempY;
		} else {
			squareCollision = true;
		}

		if (tempX > 750) {
			tempX -= 10;
		}
		if (tempX < 0) {
			tempX += 10;
		}
		if (squareCollision) {
			System.out.println("colliding");
			tempY += yVelocty;
			System.out.println(tempY);
			if (squareCollisionType == 1) {
				System.out.println("colliding 1");
				//tempX = tempX += 5;
			}
			else if (squareCollisionType == 2) {
				//tempX = tempX -= 5;
			}
			else if (squareCollisionType == 3) {
				System.out.println("colliding 3");
				tempY -= 2;
			}
			else if (squareCollisionType == 4) {
				System.out.println("colliding 4");
				tempY =  tempY+ y;
				tempX = x;
			}
			squareCollision = false;
			
		}
		if (left && !squareCollision) {
			tempX = x - 5;

		}
		if (right && !squareCollision) {
			tempX = x + 5;
			System.out.println(tempX + " " + x);
		}

		yVelocty += gravity;
		if (!squareCollision) {
			tempY += yVelocty;
		}
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
		g.fillRect(tempX, tempY, width, height);
		//System.out.println(x + " :x y: " + y);
		g2.setColor(Color.BLUE);
		g2.draw(collisionBox);
	}

}
