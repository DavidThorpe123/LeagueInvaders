import java.awt.Graphics;

public class GameObject {
	int x;
	int y;
	int width;
	int height;
	Boolean isAlive = true;

	public void update() {

		
	}

	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
