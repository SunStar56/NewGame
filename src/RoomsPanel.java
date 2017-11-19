import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;

public class RoomsPanel {
	final int TITLE_STATE = 0;
	final int ROOM_ONE = 1;
	final int ROOM_TWO = 2;
	final int ROOM_THREE = 3;
	final int END_STATE = 4;
	int state = TITLE_STATE;
	Font titleFontLarge;
	public void paintComp(Graphics g) {
		if(state == TITLE_STATE){
			drawTitleState(g);
		}else if(state == ROOM_ONE){
			drawRoomOne(g);
		}else if(state == ROOM_TWO){
			drawRoomTwo(g);
		}else if (state == ROOM_THREE) {
			drawRoomThree(g);
		}else if (state == END_STATE) {
			drawEndState(g);
		}
		
	}
	
	




	

	public RoomsPanel(){
		titleFontLarge = new Font("Arial", Font.PLAIN, 48);
		
	}
	
	 void drawTitleState(Graphics g) {
			// TODO Auto-generated method stub
			g.setColor(Color.BLACK);
			g.fillRect(500, 500, Rooms.FRAME_WIDTH, Rooms.FRAME_HEIGHT);
			g.setFont(titleFontLarge);
			g.setColor(Color.WHITE);
			g.drawString("ROOMS", 500, 500);
		}

	 void drawRoomOne(Graphics g) {
		// TODO Auto-generated method stub
		
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
	
	
	
}
