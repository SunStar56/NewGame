package Rooms;

import javax.swing.JFrame;

public class Rooms {
	JFrame frame;
	static final int FRAME_WIDTH = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int FRAME_HEIGHT = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	RoomsPanel panel;

	public Rooms() {
		frame = new JFrame();
		panel = new RoomsPanel();
		setup();
	}

	public static void main(String[] args) {
		Rooms r = new Rooms();
		ObjectManager om = new ObjectManager();
	}

	void setup() {
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		panel.startGame();
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		frame.addKeyListener(panel);
		frame.addMouseListener(panel);
	}
}
