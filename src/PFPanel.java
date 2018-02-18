
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


	public class PFPanel extends JPanel implements ActionListener, KeyListener{
		Timer timer;
		
		
		public PFPanel() {
			timer = new Timer(1000/60, this);
		}
		
		Square s = new Square(50, 50, 100, 100);
		
		void startGame() {
			timer.start();
			
		}
		
		
		
		
		public void paintComponent(Graphics g){
			s.draw(g);
			
			g.setColor(Color.GREEN);
			g.fillRect(200, 500, 100, 25);
		}
		
		public void actionPerformed(ActionEvent e){
			s.update();
			//System.out.println("XlV:"+ s.xlVelocity + "XrV:"+ s.xrVelocity);
			repaint();
			
		}

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				
				s.left = true;
			}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				s.right = true;
			}
				
				
			
				
			
			if(e.getKeyCode() == KeyEvent.VK_SPACE){
				s.jump();
			}}
			
		

		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			if(e.getKeyCode() == KeyEvent.VK_LEFT){
				s.left = false;
			}
			if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
				s.right = false;
			}
			
			
			}
			
		}
	


