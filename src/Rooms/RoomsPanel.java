package Rooms;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.MouseInfo;
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
	boolean hasSKey2;
	boolean hasKey2;
	boolean hasKey3;
	boolean doneLock;
	boolean lockShow;
	JPanel lpanel;
	String input = "a";
	Font titleFontLarge;
	Font titleFontSmall;
	String keyText;

	public static BufferedImage RoomOneImg;
	public static BufferedImage RoomTwoImg;
	public static BufferedImage RoomThreeImg;
	public static BufferedImage RoomsEndImg;
	public static BufferedImage RoomThreeLockImg;

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
		if (!hasKey1) {
			keyText = "False";
		}
		else if (hasKey1 && !hasKey2 && state == 1) {
			keyText = "True";
		}
		else if (hasKey2 && !hasKey3 && state == 2) {
			keyText = "True";
		}
		else if (hasKey3) {
			keyText = "True";
		}
		else {
			keyText = "False";
		}
		lpanel = new JPanel();
		titleFontLarge = new Font("Arial", Font.PLAIN, 48);
		titleFontSmall = new Font("Arial", Font.ITALIC, 36);

		try {
			RoomOneImg = ImageIO.read(this.getClass().getResourceAsStream("Room_One.png"));
			RoomTwoImg = ImageIO.read(this.getClass().getResourceAsStream("Room_Two.png"));
			RoomThreeImg = ImageIO.read(this.getClass().getResourceAsStream("Room_Three.png"));
			RoomThreeLockImg = ImageIO.read(this.getClass().getResourceAsStream("lockPic.jpg"));
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
			//updateEndState(g);

		}
		if (!hasKey1) {
			keyText = "False";
		}
		else if (hasKey1 && state == 1) {
			keyText = "True";
		}
		else if (hasKey2 && !hasKey3 && state == 2) {
			keyText = "True";
		}
		else if (hasKey3) {
			keyText = "True";
		}
		else {
			keyText = "False";
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
		g.setColor(Color.BLACK);
		g.setFont(titleFontSmall);
		g.drawString("Key: " + keyText, 1725, 50);
	}

	void drawRoomTwo(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT);
		g.drawImage(RoomTwoImg, 0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT, null);
		g.setColor(Color.BLACK);
		g.setFont(titleFontSmall);
		g.drawString("Key: " + keyText, 1725, 50);
	}

	void drawRoomThree(Graphics g) {
		g.setColor(Color.GREEN);
		g.fillRect(0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT);
		
		if (lockShow == true) {
			g.drawImage(RoomThreeImg, 0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT, null);
			g.drawImage(RoomThreeLockImg, 0, 0, Rooms.FRAME_WIDTH/2, Rooms.FRAME_HEIGHT/2, null);
			g.setColor(Color.BLACK);
			g.setFont(titleFontSmall);
			g.drawString("Key: " + keyText, 1725, 50);
		}
		if (lockShow == false) {
			g.drawImage(RoomThreeImg, 0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT, null);
			g.setColor(Color.BLACK);
			g.setFont(titleFontSmall);
			g.drawString("Key: " + keyText, 1725, 50);
		}
	}

	void drawEndState(Graphics g) {
		g.setFont(titleFontLarge);
		g.setColor(Color.BLACK);
		g.drawString("You Win!", 900, 540);
		g.setFont(titleFontSmall);
		g.drawString("Thanks for playing.", 850, 600);
	}

	void updateTitleState() {
		
	}

	void updateRoomOne() {
	}

	void updateRoomTwo() {

	}

	void updateRoomThree() {

	}

	void updateEndState(Graphics g) {
		if (lockShow == true) {
		g.drawImage(RoomThreeLockImg, 0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT, null);
	}
	if (lockShow == false) {
		g.drawImage(RoomThreeImg, 0, 0, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT, null);
	}
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
			} else if (hasKey2 && state == 2) {
				state += 1;
			} else if (hasKey3 && state == 3) {
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

	}

	@Override

	public void mousePressed(MouseEvent e) {
		if (state == ROOM_ONE) {
			if (IsTouching(492, 840, 707, 947)) {
				JOptionPane.showMessageDialog(null,
						"You turn the page to the bookmark and see that there is a key taped to it.  You pick it up.");
				hasKey1 = true;
			}
			if (IsTouching(719, 731, 754, 761)) {
				JOptionPane.showMessageDialog(null, ("The label reads 'The world's best teabag!  Use by: ''3377123'''."));
			}
		}
		if (state == ROOM_TWO) {
			if (IsTouching(1524, 813, 1843, 921)) {
				if (hasSKey2 == false) {
					JOptionPane.showMessageDialog(null,
							"You open the drawer to find a metal box with a small keyhole.");
				} else {
					JOptionPane.showMessageDialog(null,
							"You use the key to open the box.  Inside you find a larger door key.");
					hasKey2 = true;
				}

			}
			if (IsTouching(1544, 652, 1656, 790)) {
				JOptionPane.showMessageDialog(null, "Under the drink you find a small key.");
				hasSKey2 = true;
			}
		}
		if (state == ROOM_THREE) {
			if (IsTouching(1161, 198, 1838, 709)) {
				if (hasKey3 == false) {
					lockShow = true;
				}
			}
			else if (IsTouching(169,	345,	 388	, 469)) {
				input = input + "1";
				System.out.println(input);
			}
			else if (IsTouching(385, 347, 589, 469)) {
				input = input + "2";
				System.out.println(input);
			}
			else if (IsTouching(596,	352, 791, 462)) {
				input = input+ "3";
				System.out.println(input);
			}
			else if (IsTouching(182, 234, 387, 355)) {
				input = input + "4";
				System.out.println(input);
			}
			else if (IsTouching(386, 234, 591, 347)) {
				input = input + "5";
				System.out.println(input);
			}
			else if (IsTouching(595, 238, 792, 351)) {
				input = input + "6";
				System.out.println(input);
			}
			else if (IsTouching(170, 110, 386, 237)) {
				input = input + "7";
				System.out.println(input);
			}
			else if (IsTouching(386, 114, 595, 235)) {
				input = input + "8";
				System.out.println(input);
			}
			else if (IsTouching(591, 116, 794, 232)) {
				input = input + "9";
				System.out.println(input);
			}
			input = input.replace("a", "");
			if (input.equals("3377123")) {
				JOptionPane.showMessageDialog(null, "You enter the code " + input + " and the lock opens.");
				hasKey3 = true;
				lockShow = false;
				doneLock = true;
			}
			if (input.length() > 6  ) {
				if (doneLock == false) {
					JOptionPane.showMessageDialog(null, "You enter the code " + input + "... But the lock won't open.");
					input="a";
				}
				lockShow = false;
			}
		}
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

	public boolean IsTouching(int xcoord, int ycoord, int xcoord2, int ycoord2) {
		Point m = MouseInfo.getPointerInfo().getLocation();
		System.out.println("x" + m.x);
		System.out.println("y" + m.y);

		if (m.x >= xcoord && m.y >= ycoord && m.x <= xcoord2 && m.y <= ycoord2) {
			return true;
		} else {
			return false;
		}

	}
}
