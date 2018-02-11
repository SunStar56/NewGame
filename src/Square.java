import java.awt.Color;
import java.awt.Graphics;

public class Square {
		private int x;
		private int y;
		private int width;
		private int height;
		
		public boolean left = false;
		public boolean right = false;
		
		int xlVelocity = 5;
		int xrVelocity = 5;
		int gravity = 1;
		int yVelocty = 0;
		int xVelocty = 0;
		int jumpPower = 20;
		
		int yLimit = 500;

		boolean canJump = true;
		
		public Square(int x, int y, int w, int h){
			this.x = x;
			this.y = y;
			this.width = w;
			this.height = h;
		}
		
		public void jump(){
			if(canJump){
				yVelocty -= jumpPower;
				canJump = false;
			}
		}
		
		public void update(){
			if(left){
				x -= xlVelocity;
			}
			if(right){
				x += xrVelocity;
			}
			
			yVelocty += gravity;
			y += yVelocty;
			
			if(y >= yLimit){
				y = yLimit;
				yVelocty = 0;
				canJump = true;
			}
			
		}
		
		public void draw(Graphics g){
			g.setColor(Color.BLUE);
			g.fillRect(x, y, width, height);
		}
	}

