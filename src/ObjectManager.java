
import java.awt.Graphics;
import java.util.ArrayList;

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
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				GameObject o1 = objects.get(i);
				GameObject square = objects.get(j);
				if (o1.collisionBox.intersects(square.collisionBox)) {
					// if ((o1 instanceof Steps) || (square instanceof Steps)) {
					o1.isAlive = false;
					square.isAlive = false;
				}

			}
		}
	}
	// }

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
		Steps ap1 = new Steps(250, 500, 100, 25);
		objects.add(ap1);
		Steps ap2 = new Steps(500, 400, 100, 25);
		objects.add(ap2);
	}
	public void setup2() {
		Steps bp1 = new Steps(1,1,1,1);
	}
}
