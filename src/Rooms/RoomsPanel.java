package Rooms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class RoomsPanel extends JPanel implements ActionListener, KeyListener, MouseListener {
	Timer timer;
	final int TITLE_STATE = 0;
	final int ROOM_ONE = 1;
	final int ROOM_TWO = 2;
	final int ROOM_THREE = 3;
	final int END_STATE = 4;
	int state = TITLE_STATE;
	final int LBOUNDSX = 50;
	final int LBOUNDSY = 500;
	final int RBOUNDSX = 1820;
	final int RBOUNDSY = 500;
	Font titleFontLarge;

	public void paintComponent(Graphics g) {
		if (state == TITLE_STATE) {
			drawTitleState(g);
		} else if (state == ROOM_ONE) {
			drawRoomOne(g);
		} else if (state == ROOM_TWO) {
			drawRoomTwo(g);
		} else if (state == ROOM_THREE) {
			drawRoomThree(g);
		} else if (state == END_STATE) {
			drawEndState(g);
		}

	}

	public RoomsPanel() {
		timer = new Timer(1000 / 60, this);
		titleFontLarge = new Font("Arial", Font.PLAIN, 48);
	}

	void startGame() {
		timer.start();
	}

	public void actionPerformed(ActionEvent e) {
		repaint();
		if (state == TITLE_STATE) {
			updateTitleState();
		} else if (state == ROOM_ONE) {
			updateRoomOne();
		} else if (state == ROOM_TWO) {
			updateRoomTwo();
		} else if (state == ROOM_THREE) {
			updateRoomThree();
		} else if (state == END_STATE) {
			updateEndState();
		}
	}

	void drawTitleState(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, Rooms.FRAME_WIDTH + 50, Rooms.FRAME_HEIGHT);
		g.setFont(titleFontLarge);
		g.setColor(Color.WHITE);
		g.drawString("ROOMS", 900, 540);
		System.out.println(Rooms.FRAME_HEIGHT);
		System.out.println(Rooms.FRAME_WIDTH);
		g.setColor(Color.GRAY);
	}

	void drawRoomOne(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT);
	}

	void drawRoomTwo(Graphics g) {
		// TODO Auto-generated method stub

	}

	void drawRoomThree(Graphics g) {
		// TODO Auto-generated method stub

	}

	void drawEndState(Graphics g) {
		// TODO Auto-generated method stub

	}

	void updateTitleState() {
		// TODO Auto-generated method stub
	}

	void updateRoomOne() {

	}

	void updateRoomTwo() {

	}

	void updateRoomThree() {

	}

	void updateEndState() {

	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			state -= 1;
			if (state < 0) {
				state = 4;
			}
			System.out.println(state);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			state += 1;
			if (state > 4) {
				state = 0;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override

	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override

	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override

	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override

	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}
}
