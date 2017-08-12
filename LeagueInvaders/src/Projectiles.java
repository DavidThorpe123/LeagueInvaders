import java.awt.Color;
import java.awt.Graphics;

public class Projectiles extends GameObject {
	
	int speed;
Projectiles(int x, int y, int height, int width) {
speed = new Integer(10);

}
public void draw(Graphics g) {
	g.setColor(Color.RED);
	g.drawRect(x, y, width, height);
}
public void update() {
	y = y - speed;
	if (y < 0) {
		isAlive = false;
	}
}
}
