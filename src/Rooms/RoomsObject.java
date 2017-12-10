package Rooms;

import java.awt.Graphics;
import java.awt.Rectangle;

public class RoomsObject {
	int x;
	int y;
	int width;
	int height;
	Rectangle boundingBox = new Rectangle();

	public RoomsObject(int x, int y, int width, int height) {
		this.x = x;
		this.y = y;
		this.width = width;
		this.height = height;

	}

	void update() {
		boundingBox.setBounds(x, y, width, height);

	}

	public void draw(Graphics g) {

	}
}
