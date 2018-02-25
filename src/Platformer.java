import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.Timer;

public class Platformer {
	JFrame window;
	PFPanel panel;
	public static final int WIDTH = 800;
	public static final int HEIGHT = 600;
	Timer timer;

	public Platformer() {
		window = new JFrame();
		panel = new PFPanel();
		setup();

	}

	public static void main(String[] args) {
		Platformer pf = new Platformer();

	}

	void setup() {
		window = new JFrame("Platform Thing");
		window.addKeyListener(panel);
		window.add(panel);
		panel.startGame();
		window.setSize(WIDTH, HEIGHT);
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
		window.setVisible(true);
		window.pack();
		timer = new Timer(1000 / 60, panel);

	}
}