import java.awt.Color;
import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;
	
Rocketship(int x, int y, int width, int height) {
	speed = new Integer(5);
	

}
public void update() {
	
}
public void draw(Graphics g) {
	g.setColor(Color.BLUE);
	g.fillRect(x, y, width, height);
}
}
