import javax.swing.JFrame;
import javax.swing.JPanel;

public class Rooms {
	JFrame frame;
	static final int FRAME_WIDTH = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
	static final int FRAME_HEIGHT = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
	JPanel panel;
	
	public Rooms() {
		frame = new JFrame();
		panel = new JPanel();	
		setup();
	}
	public static void main(String[] args) {
		Rooms r = new Rooms();
	}
	void setup() {
		frame.add(panel);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);
		
	}
}
