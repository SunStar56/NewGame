package Rooms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JOptionPane;
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
	boolean hasKey1;
	Font titleFontLarge;
	Font titleFontSmall;
	ObjectManager obj = new ObjectManager();

	public static BufferedImage RoomOneImg;
	public static BufferedImage RoomTwoImg;
	public static BufferedImage RoomThreeImg;

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
		titleFontSmall = new Font("Arial", Font.ITALIC, 36);

		try {
			RoomOneImg = ImageIO.read(this.getClass().getResourceAsStream("Room_One.png"));
			RoomTwoImg = ImageIO.read(this.getClass().getResourceAsStream("Room_Two.png"));
			RoomThreeImg = ImageIO.read(this.getClass().getResourceAsStream("Room_Three.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
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
		g.setFont(titleFontSmall);
		g.drawString("Arrow Keys to switch between rooms, click on things to interact with them.", 400, 800);
		g.setColor(Color.GRAY);

	}

	void drawRoomOne(Graphics g) {
		g.setColor(Color.RED);
		g.fillRect(0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT);
		g.drawImage(RoomOneImg, 0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT, null);
	}

	// }

	void drawRoomTwo(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT);
		g.drawImage(RoomTwoImg, 0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT, null);
		g.setColor(Color.black);
		g.fillRect(50, 50, 100, 100);
	}

	void drawRoomThree(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT);
		g.drawImage(RoomThreeImg, 0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT, null);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.fillRect(0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT);
		g.setFont(titleFontLarge);
		g.setColor(Color.BLACK);
		g.drawString("You Win!", 900, 540);
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
			if (hasKey1 == true) {
				state -= 1;
				if (state < 0) {
					state = 0;
				}
			}
			System.out.println(state);
		} else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			if (state == 0) {
				state += 1;
			} else if (hasKey1 && state == 1) {
				state += 1;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override

	public void mouseClicked(MouseEvent e) {
		Point m = getMousePosition();
		System.out.println("here at " + m.x + ", " + m.y + "");
	}

	@Override

	public void mousePressed(MouseEvent e) {
		// if (IsTouching(50, 50, 100, 100)) {
		// System.out.println("Touching");
		// } else {
		// System.out.println("Not touching");
		// }
		// Book Touching
		if (IsTouching(501, 844, 700, 897)) {
			JOptionPane.showMessageDialog(null,
					"You turn the page to the bookmark and see that there is a key taped to it.  You pick it up.");
			hasKey1 = true;
			if (IsTouching(747, 713, 718, 690)) {
				JOptionPane.showMessageDialog(null, ("The label reads ''3377123''."));

			}
		}
	}

	// }

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

	public boolean IsTouching(int xcoord, int ycoord, int xcoord2, int ycoord2) {
		Point m = getMousePosition();
		System.out.println(xcoord + " " + ycoord + " " + xcoord2 + " " + ycoord2);
		if (m.x >= xcoord && m.y >= ycoord && m.x <= xcoord2 && m.y <= ycoord2) {
			return true;
		} else {
			return false;
		}

	}
}
