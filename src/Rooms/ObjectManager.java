package Rooms;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JOptionPane;

public class ObjectManager {
	ArrayList<RoomsObject> objects;

	public ObjectManager() {
		objects = new ArrayList<RoomsObject>();
	}

	public void addObject(RoomsObject o) {
		objects.add(o);
	}

	public void setup() {
		// Object book = objects.add(new RoomsObject(50, 50, 50, 50));
	}

	public void update() {
		for (int i = 0; i < objects.size(); i++) {
			RoomsObject o = objects.get(i);
			o.update();
		}
	}

	public void draw(Graphics g) {
		for (int i = 0; i < objects.size(); i++) {
			RoomsObject o = objects.get(i);
			o.draw(g);
		}
	}

	public void manageObjects() {
		addObject(new RoomsObject(new Random().nextInt(Rooms.FRAME_WIDTH), 0, 50, 50));
	}

	public void checkCollision() {
		for (int i = 0; i < objects.size(); i++) {
			for (int j = i + 1; j < objects.size(); j++) {
				RoomsObject o1 = objects.get(i);
				RoomsObject o2 = objects.get(j);

				if (o1.boundingBox.intersects(o2.boundingBox)) {
					JOptionPane.showMessageDialog(null, "Touched");
				}
			}
		}
	}
}
