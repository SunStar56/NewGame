
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
	public void setup(int level) {
		if (level == 1) {
			setup1();
		}
		if (level == 2) {
			setup2();
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
			s.draw(g);
		}
		for (int i = 0; i < goals.size(); i++) {
			GameObject gls = goals.get(i);
			gls.draw(g);
		}
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			GameObject o1 = objects.get(i);
			
			if (o1.collisionBox.intersects(s.collisionBox)) {
				if (s.collisionBox.y + s.height > o1.collisionBox.y + 5 && s.collisionBox.x + s.width > o1.collisionBox.x){
					s.stuck = true;
				}
				s.squareCollision = true;
			}
			for (int j = 0; j < goals.size(); j++) {
				GameObject g1 = goals.get(j);
				if (g1.collisionBox.intersects(s.collisionBox)) { 
					s.touchGoal = true;
					s.squareCollision = true;
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
	
	public void setSquare() {
		Square s = new Square(50, 100, Square.size, Square.size);
	}

	public void setup1() {
		
		if (!setup1complete) {
			setSquare();
			Steps ap1 = new Steps(0, 200, 100, 25);
			ap1.collisionBox.setBounds(0, 250, 100, 25);
			objects.add(ap1);
			Steps ap2 = new Steps(150, 400, 100, 25);
			ap2.collisionBox.setBounds(150, 400, 100, 25);
			objects.add(ap2);
			Steps ap3 = new Steps (350, 350, 100, 25);
			ap3.collisionBox.setBounds(350, 350, 100, 25 );
			objects.add(ap3);
			Steps ap4 = new Steps(550, 450, 100, 25);
			ap4.collisionBox.setBounds(550, 450, 100, 25);
			objects.add(ap4);
			Steps ap5 = new Steps(700, 350, 100, 25);
			ap5.collisionBox.setBounds(700,350, 100, 25);
			objects.add(ap5);
			Goals ag1 = new Goals(750, 310, 25, 25);
			ag1.collisionBox.setBounds(750, 310, 25, 25);
			goals.add(ag1);
			// System.out.println(setup1complete);
			setup1complete = true;
		}
	}

	public void setup2() {
		setSquare();
		objects.clear();
		goals.clear();
		Steps bp1 = new Steps(0, 200, 100, 25);
		bp1.collisionBox.setBounds(0, 200, 100, 25);
		objects.add(bp1);
		Steps bp2 = new Steps(150, 150, 100, 25);
		bp2.collisionBox.setBounds(150, 150, 100, 25);
		objects.add(bp2);
		Steps bp3 = new Steps(375, 300, 100, 25);
		bp3 = new Steps(375, 300, 100, 25);
		objects.add(bp3);
	}
}
