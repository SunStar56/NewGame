import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

public class PF extends JPanel implements ActionListener, KeyListener {
 public static final int SCREENWIDTH = 600;
 public static final int SCREENHEIGHT = 400;
 public static final int LVL_ONE = 1;
 public static final int LVL_TWO = 2;
 int state;
 
 JFrame window;
 Timer t;
 
// Player p = new Player(50,50,50,50);
 
 public static void main(String[] args) {
	new PF().run();
}
 public void run() {
	 window = new JFrame("Platform");
	 window.setVisible(true);
	 window.add(this);
	 window.addKeyListener(this);
	 window.getContentPane().setPreferredSize(new Dimension(SCREENWIDTH, SCREENHEIGHT));
	 t = new Timer(1000/60, this);
	 t.start();
 }
 @Override
 public void paintComponent(Graphics g) {
		//p.draw(g);
	}
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyCode() == KeyEvent.VK_W) {
			
		}
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}



