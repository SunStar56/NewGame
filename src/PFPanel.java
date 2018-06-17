
import java.awt.Color;
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
	public static boolean moveRight = false;
	public static boolean moveLeft = false;
	public static boolean jump = false;
	boolean setupcomplete;
	Square s;
	Square sHB;

	int state = T_STATE;
	ObjectManager om;

	public PFPanel() {
		timer = new Timer(1000 / 60, this);
		s = new Square(50, 50, Square.size, Square.size);
		om = new ObjectManager(s);

		sHB = new Square(40, 40, Square.size + 10, Square.size + 10);
	}

	void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (state != T_STATE && state != E_STATE) {
		}
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
	}

	public void actionPerformed(ActionEvent e) {
		if (setupcomplete == false) {
			om.setup1();
			setupcomplete = true;
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

		if (state != T_STATE || state != E_STATE) {
			om.update();
			om.checkCollision();

		}
		// System.out.println("checked");
		repaint();

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_E) {
			if (state != E_STATE) {
				state = state + 1;
			} else {
				if (state == E_STATE) {
					state = T_STATE;
					setupcomplete = false;
				}
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			if (state != T_STATE) {
				state = state - 1;
			}
		}

		if (e.getKeyCode( ) == KeyEvent.VK_R) {
			
		}
		
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			moveLeft = true;
			//System.out.println("left");
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			moveRight = true;
			//System.out.println("right");
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			jump = true;
			//System.out.println("jump");
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
	}

	void drawState1(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		om.setup1();
		om.draw(g);
		s.draw(g, Color.WHITE);
	}

	void drawState2(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		s.draw(g, Color.BLACK);

	}

	void drawState3(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		s.draw(g, Color.WHITE);
	}

	void drawState4(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		s.draw(g, Color.BLACK);

	}

	void drawState5(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		s.draw(g, Color.WHITE);
	}

}
