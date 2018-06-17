
import java.awt.Graphics;
import java.util.ArrayList;

public class ObjectManager {
	ArrayList<GameObject> objects;

	private int score = 0;
	boolean setup1complete = false;
	Square s;
	ArrayList<GameObject> goals;

	long enemyTimer = 0;
	int enemySpawnTime = 1000;

	public ObjectManager(Square s) {
		objects = new ArrayList<GameObject>();
		this.s = s;
		this.goals = new ArrayList<GameObject>();
	}

	public void addObject(GameObject steps) {
		objects.add(steps);
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			GameObject gls = goals.get(i);
			o.update();
			gls.update();
		}
		s.update();


	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o = objects.get(i);
			GameObject gls = goals.get(i);
			o.draw(g);
			s.draw(g);
			gls.draw(g);
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o1 = objects.get(i);
			GameObject g1 = objects.get(i);
			if (o1.collisionBox.intersects(s.collisionBox)) {
				if (s.collisionBox.y + s.height > o1.collisionBox.y + 5 && s.collisionBox.x + s.width > o1.collisionBox.x){
					s.stuck = true;
				}
		
				// results
				// s.tempY = s.getY() + o1.y;
				// System.out.println(s.y);
				// s.collisionBox.setBounds(s.x, o1.y - s.height, 50, 50);
				// System.out.println("Did the thing");
				
				s.squareCollision = true;

			}
			if (g1.collisionBox.intersects(s.collisionBox)) {
				if(s.collisionBox.y + s.height > g1.collisionBox.y + 5 && s.collisionBox.x + s.width > g1.collisionBox.x) {
					
				}
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
		if (!setup1complete) {
			Steps afloor = new Steps(0, 575, 800, 50);
			afloor.collisionBox.setBounds(0, 575, 800, 50);
			objects.add(afloor);
			Steps ap1 = new Steps(0, 200, 100, 25);
			ap1.collisionBox.setBounds(0, 250, 100, 25);
			objects.add(ap1);
			Steps ap2 = new Steps(150, 400, 100, 25);
			ap2.collisionBox.setBounds(150, 400, 100, 25);
			objects.add(ap2);
			Steps ap3 = new Steps (400, 350, 100, 25);
			ap3.collisionBox.setBounds(400, 350, 100, 25 );
			objects.add(ap3);
			Goals ag1 = new Goals(775, 500, 25, 25);
			ag1.collisionBox.setBounds(775, 500, 25, 25);
			goals.add(ag1);
			// System.out.println(setup1complete);
			setup1complete = true;
		}
	}

	public void setup2() {
		// Steps bp1 = new Steps(1, 1, 1, 1);
	}
}
