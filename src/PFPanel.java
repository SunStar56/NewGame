
import java.awt.Color;
import java.awt.Graphics;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class PFPanel extends JPanel implements ActionListener, KeyListener {
	Timer timer;
	final int WINDOW_W = 800;
	final int WINDOW_H = 600;
	final int T_STATE = 0;
	final int STATE_1 = 1;
	final int STATE_2 = 2;
	final int STATE_3 = 3;
	final int STATE_4 = 4;
	final int STATE_5 = 5;
	final int E_STATE = 6;
	int state = T_STATE;
	ObjectManager om;

	public PFPanel() {
		timer = new Timer(1000 / 60, this);
		om = new ObjectManager(s);
	}

	Square s = new Square(50, 50, Square.size, Square.size);
	Square sHB = new Square(40, 40, Square.size + 10, Square.size + 10);

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
		s.update();
		System.out.println(s.atRest);
		repaint();

		if (IsTouching(s.tempX, sHB.y, sHB.x + 50, sHB.y + 50, 225, 460, 375)) {
			s.squareCollision = true;
			System.out.println("WORKS");
		} else {
			s.squareCollision = false;
		}

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_E) {
			if (state != 6) {
				state = state + 1;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_Q) {
			if (state != 0) {
				state = state - 1;
			}
		}
		if (s.canMoveL) {
			if (e.getKeyCode() == KeyEvent.VK_LEFT) {

				s.left = true;
			}
		}
		if (!s.canMoveL) {
			s.x = s.x + 5;
		}
		if (s.canMoveR) {
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				s.right = true;
			}
		}

		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			s.jump();
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			s.left = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			s.right = false;
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 550, WINDOW_W, 100);
		s.draw(g, Color.WHITE);
	}

	void drawState2(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 550, WINDOW_W, 100);
		s.draw(g, Color.BLACK);

	}

	void drawState3(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		g.setColor(Color.BLACK);
		g.fillRect(0, 550, WINDOW_W, 100);
		s.draw(g, Color.WHITE);
	}

	void drawState4(Graphics g) {
		g.setColor(Color.LIGHT_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 550, WINDOW_W, 100);
		s.draw(g, Color.BLACK);

	}

	void drawState5(Graphics g) {
		g.setColor(Color.DARK_GRAY);
		g.fillRect(0, 0, WINDOW_W, WINDOW_H);
		g.setColor(Color.BLACK);
		g.fillRect(0, 550, WINDOW_W, 100);
		s.draw(g, Color.WHITE);
	}

	public boolean IsTouching(int x, int y, int x2, int y2, int tx, int ty, int tx2) {
		Point m = MouseInfo.getPointerInfo().getLocation();
		System.out.println("x" + m.x);
		System.out.println("y" + m.y);
		// 250-350
		if (x >= tx && y < ty && y > ty - 25 && x2 <= tx2) {
			return true;
		} else {
			return false;
		}

	}
}
