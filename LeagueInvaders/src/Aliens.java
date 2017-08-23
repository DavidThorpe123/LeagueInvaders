import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Random;

public class Aliens extends GameObject {
	Rectangle collision;

	Aliens(int x, int y, int width, int height) {

		super(x, y, width, height);
		collision = new Rectangle(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.drawImage(GamePanel.alienimg, x, y, width, height, null);
	}

	public void update() {
		super.update();
		collision.setBounds(x, y, width, height);
		y++;
		super.update();
		int ran = new Random().nextInt(4);
		System.out.println(ran);
		switch (ran) {
		case 0:
			x = x + 2;
			break;
		case 1:
			x = x + 2;
			break;
		case 2:
			x = x - 2;
			break;
		case 3:
			x = x - 2;
			break;
		case 4:
			x = x + 2;
			break;
		}
	}
}
