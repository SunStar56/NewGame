
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JPanel;
import javax.swing.Timer;
public class PFPanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	public static final int WINDOW_W = 800;
	public static final int WINDOW_H = 600;
	final int T_STATE = 0;
	final int STATE_1 = 1;
	final int STATE_2 = 2;
	final int STATE_3 = 3;
	final int STATE_4 = 4;
	final int STATE_5 = 5;
	final int E_STATE = 6;
	int setuplvl = 1;
	int finishIf = 0;
	public static boolean moveRight = false;
	public static boolean moveLeft = false;
	public static boolean jump = false;
	boolean setupcomplete1;
	boolean setupcomplete2;
	boolean setupcomplete3;
	boolean setupcomplete4;
	boolean setupcomplete5;
	Font InstructionsFont;
	Square s;
	int state = T_STATE;
	ObjectManager om;
	public PFPanel() {
		timer = new Timer(1000 / 60, this);
		s = new Square(50, 50, Square.size, Square.size);
		om = new ObjectManager(s);
		InstructionsFont = new Font("Arial", Font.PLAIN, 24);
		
	}
	void startGame() {
		timer.start();
	}
	public void paintComponent(Graphics g) {	
		if (state == T_STATE) {
			drawTState(g);
		}
		if (state == STATE_1) {
			drawState1(g);
		}
		if (state == STATE_2) {
			drawState2(g);
		}
		if (state == STATE_3) {
			drawState3(g);
		}
		if (state == STATE_4) {
			drawState4(g);
		}
		if (state == STATE_5) {
			drawState5(g);
		}
		if (state == E_STATE) {
			drawEState(g);
		}
		
		
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(state);
		if (setupcomplete1 == false && state == 1) {
			om.setup(1);
		}
		if (setupcomplete2 == false && state == 2) {
			om.setup(2);
		}
		if (setupcomplete3 == false && state == 3) {
			om.setup(3);
		}
		if (setupcomplete4 == false && state == 4) {
			om.setup(4);
		}
		if (setupcomplete5 == false && state == 5) {
			om.setup(5);
		}
		if (moveLeft == true) {
			s.moveLeft(5);
		}
		if (moveRight == true) {
			s.moveRight(5);
		}
		if (jump == true) {
			s.jump();
		}
		if (s.finishLevel == true) {
			System.out.println("s.finishLevel was true.");
			s.finishLevel = false;
			s.tempX = 50;
			s.tempY = 300;
			//om.setup(state + 1);		
			System.out.println(state);
			nextLevel(state);

		}
		
		
		if (state != T_STATE || state != E_STATE) {
			om.update();
			om.checkCollision();
		}

		repaint();
}
	public void keyTyped(KeyEvent e) {
		
	}
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_E) {
			if (state == T_STATE) {
				state = 1;
			}
		}
		
		if (e.getKeyCode( ) == KeyEvent.VK_R ) {
			if (state == STATE_1 || state == STATE_2 || state == STATE_3 && s.tempX != 50 && s.tempY != 100) {
					s.tempX = 50;
					s.tempY = 100;	
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump = true;
		}
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump = false;
		}
	}
	void drawTState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		g.setFont(InstructionsFont);
		g.setColor(Color.DARK_GRAY);
		g.drawString("Use arrow keys to move, press R to begin the game.  Have fun!", 50, 400);
	}
	void drawState1(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		om.setup(1);
		om.draw(g);
		s.draw(g, Color.WHITE);
	}
	void drawState2(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		om.setup(2);
		om.draw(g);
		s.draw(g, Color.BLACK);
	}
	void drawState3(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		om.setup(3);
		om.draw(g);
		s.draw(g, Color.WHITE);
	}
	void drawState4(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		om.setup(4);
		om.draw(g);
		s.draw(g, Color.BLACK);
	}
	void drawState5(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		om.setup(5);
		om.draw(g);
		s.draw(g, Color.WHITE);
	}
	void drawEState(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		g.setColor(Color.DARK_GRAY);
		g.setFont(InstructionsFont);
		g.drawString("You won!  Thanks for playing.", 250, 300);
	}
	void nextLevel(int currentState) {
	if (currentState == STATE_5) {
		state = E_STATE;
	}
	else if (currentState == STATE_4) {
		state = STATE_5;
	}
	else if (currentState == STATE_3) {
		state = STATE_4;
	}
	else if (currentState == STATE_2) {
		state = STATE_3;
	}
	else if (currentState == STATE_1) {
		state = STATE_2;
	}
	s.finishLevel = false;
	}
}
