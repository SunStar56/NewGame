import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Goals extends GameObject {

	public Goals(int x, int y, int width, int height) {
		super(x, y, width, height);

	}

	public void draw(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
		g2.setColor(Color.YELLOW);
		g2.fillRect(x, y, width, height);
	}

	public void update() {
		super.update();

	}

}
