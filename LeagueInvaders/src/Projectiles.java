import java.awt.Graphics;
import java.awt.Rectangle;

public class Projectiles extends GameObject {

	int speed;
	Rectangle collision2;

	Projectiles(int x, int y, int height, int width) {

		super(x, y, width, height);
		speed = new Integer(10);
		collision2 = new Rectangle(x, y, height, width);

	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.bulletimg, x, y, width, height, null);

	}

	public void update() {
		collision2.setBounds(x, y, width, height);
		super.update();
		y = y - speed;
		if (y < 0) {
			isAlive = false;
		}
	}
}
