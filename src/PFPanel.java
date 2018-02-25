
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

	public PFPanel() {
		timer = new Timer(1000 / 60, this);
	}

	Square s = new Square(50, 50, Square.size, Square.size);

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
		repaint();

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
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {

			s.left = true;
		}

		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			s.right = true;
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
		g.setColor(Color.BLACK);
		g.fillRect(0, 550, WINDOW_W, 100);
		s.draw(g, Color.WHITE);
		System.out.println(s.goingUp);
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
}
