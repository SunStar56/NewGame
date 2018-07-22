
import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objects;
	ArrayList<GameObject> goals;
	private int score = 0;
	boolean setup1complete = false;
	boolean setup2complete = false;
	boolean setup3complete = false;
	Square s;
	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public ObjectManager(Square s) {
		objects = new ArrayList<GameObject>();
		this.s = s;
		goals = new ArrayList<GameObject>();
	}

	public void setup(int level) {
		if (level == 1) {
			setup1();
		}
		if (level == 2) {
			setup2();
		}
		if (level == 3) {
			setup3();
		}

	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.update();
		}
		for (int i = 0; i < goals.size(); i++) {
			GameObject gls = goals.get(i);
			gls.update();
		}
		s.update();

	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			o.draw(g);
		}
		for (int i = 0; i < goals.size(); i++) {
			GameObject gls = goals.get(i);
			gls.draw(g);
		}
		s.draw(g);
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o1 = objects.get(i);
			if (o1.collisionBox.intersects(s.collisionBox)) {
				if (s.collisionBox.y + s.height > o1.collisionBox.y + 5
						&& s.collisionBox.x + s.width > o1.collisionBox.x) {
					s.stuck = true;
				}
				s.squareCollision = true;
			}

		}
		for (int j = 0; j < goals.size(); j++) {
			GameObject g1 = goals.get(j);
			if (g1.collisionBox.intersects(s.collisionBox)) {
				s.touchGoal = true;
				s.squareCollision = true;
				System.out.println("touchgoal");
				
			}

		}

	}

	public int getScore() {
		return score;
	}

	public void setScore(int s) {
		score = s;
	}

	public void setSquare() {
		s.setPos(50, 100);
		update();
	}

	public void setup1() {

		if (!setup1complete) {
			System.out.println("Ran setup1()");

			setSquare();
			objects.clear();
			goals.clear();

			objects.add(new Steps(0, 200, 100, 25));
			objects.add(new Steps(150, 400, 100, 25));
			objects.add(new Steps(350, 350, 100, 25));
			objects.add(new Steps(550, 450, 100, 25));
			objects.add(new Steps(700, 350, 100, 25));

			goals.add(new Goals(750, 310, 25, 25));

			setup1complete = true;
			System.out.println(setup1complete);
		}
	}

	public void setup2() {
		if (!s.squareCollision && !setup2complete) {

			setSquare();
			objects.clear();
			goals.clear();

			objects.add(new Steps(0, 500, 100, 25));
			objects.add(new Steps(150, 425, 100, 25));
			objects.add(new Steps(350, 350, 100, 25));
			objects.add(new Steps(550, 425, 100, 25));
			objects.add(new Steps(700, 500, 100, 25));

			goals.add(new Goals(750, 460, 25, 25));

			setup2complete = true;
		}
	}

	public void setup3() {
		if (!s.squareCollision && !setup3complete) {
			
			setSquare();
			objects.clear();
			goals.clear();
			
			objects.add(new Steps(0, 500, 100, 25));
			
			setup3complete = true;

		}

	}
}
