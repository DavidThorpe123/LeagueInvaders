import java.awt.Graphics;

public class Rocketship extends GameObject {
	int speed;

	Rocketship(int x, int y, int width, int height) {
		super(x, y, width, height);
		speed = new Integer(5);

	}

	public void update() {
		super.update();
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.rocketimg, x, y, width, height, null);
	}
}
