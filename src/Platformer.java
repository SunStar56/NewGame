
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


	public class Platformer extends JPanel implements ActionListener, KeyListener{
		public static final int WIDTH = 800;
		public static final int HEIGHT = 600;
		
		JFrame window;
		Timer timer;
		
		Square s = new Square(50, 50, 100, 100);
		
		public static void main(String[] args) {
			new Platformer().run();
			new Platforms();
		}
		
		public void run(){
			window = new JFrame("Platform Thing");
			window.addKeyListener(this);
			window.add(this);
			window.getContentPane().setPreferredSize(new Dimension(WIDTH, HEIGHT));
			window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			window.setVisible(true);
			window.pack();
			timer = new Timer(1000 / 60, this);
			timer.start();
			
		}
		
		public void paintComponent(Graphics g){
			s.draw(g);
			
			g.setColor(Color.GREEN);
			g.fillRect(200, 500, 100, 25);
		}
		
		public void actionPerformed(ActionEvent e){
			s.update();
			System.out.println("XlV:"+ s.xlVelocity + "XrV:"+ s.xrVelocity);
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
				//s.xrVelocity -=1;
			}
			//if (s.xrVelocity > 10) {
				//s.xrVelocity = 10;
			//}
			//if (s.xrVelocity < -10) {
				//s.xrVelocity = -10;
			//}
			
			if(e.getKeyCode() == KeyEvent.VK_RIGHT){
				s.right = true;
				//s.xrVelocity += 1;
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
	


