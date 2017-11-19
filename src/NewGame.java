import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Rectangle2D;

public class NewGame extends JComponent implements ActionListener, Runnable
{
    private int widthOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
    private int heightOfScreen = java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
     static JFrame mainGameWindow;
     static JPanel mainGamePanel;
    private Rectangle2D.Double floor = new Rectangle2D.Double(0, 0, widthOfScreen, heightOfScreen);
    private Timer paintTicker = new Timer(20, this); //Ticks every 20 milliseconds (50 times per second); calls on actionPerformed() when it ticks.
    final int TITLE_STATE = 0;
    final int ROOM_ONE = 1;
    final int ROOM_TWO = 2;
    final int ROOM_THREE = 3;
    final int END_STATE = 4;
    static int gameState;
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new NewGame());
        gameState = 0;
        mainGameWindow = new JFrame("NewGame");//Makes window with title "NewGame"
        mainGamePanel = new JPanel();
    }

    public void run()
    {


       // mainGameWindow.add(this);//Adds the paint method
       // mainGameWindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // mainGameWindow.setVisible(true);
       // paintTicker.start();
        
    }

    public void paint(Graphics g)
    {
    	Graphics2D g2 = (Graphics2D)g;
      if (gameState == 0) {
		drawTitleState(g);
	}
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        repaint();
        //Calls on the paint() method.
    }
    
    	void changeGameState() {
    		
    		
    	}
    	void setGameState() {
    		
    		
    	}
    	void drawTitleState(Graphics g) {
    		g.setColor(Color.black);
    		g.fillRect(0, 0, widthOfScreen, heightOfScreen);
    		
    	}
    	void drawRoomOne(Graphics g) {
    		g.setColor(Color.red);
    		g.fillRect(0, 0, widthOfScreen, heightOfScreen);
    	}
    	





}
