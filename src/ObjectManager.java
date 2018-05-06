
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JOptionPane;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;
	Square s;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public ObjectManager(Square s) {
		objects = new ArrayList<GameObject>();
		this.s = s;
	}

	public void addObject(GameObject steps) {
		objects.add(steps);

	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}

	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
			s.draw(g);
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
				GameObject o1 = objects.get(i);
				if (o1.collisionBox.intersects(s.collisionBox)) {
					//results
					//s.tempY = s.getY() + o1.y;
					//System.out.println(s.y);
					//s.collisionBox.setBounds(s.x, o1.y - s.height, 50, 50);
					//System.out.println("Did the thing");
					if (s.x + s.width > o1.collisionBox.x && s.y > o1.collisionBox.y && s.y < o1.collisionBox.y + o1.collisionBox.height && s.x < o1.collisionBox.x + o1.collisionBox.width) {
						
					}
					s.squareCollision = true;
					
				}
		}
	}
	
	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void reset() {
		objects.clear();
	}

	public void setup1() {
		Steps afloor = new Steps(0, 600, 800, 50);
		objects.add(afloor);
		Steps ap1 = new Steps(250, 500, 100, 25);
		ap1.collisionBox.setBounds(250, 500, 100, 25);
		objects.add(ap1);
		Steps ap2 = new Steps(500, 400, 100, 25);
		objects.add(ap2);
	}
	public void setup2() {
		Steps bp1 = new Steps(1,1,1,1);
	}
}
