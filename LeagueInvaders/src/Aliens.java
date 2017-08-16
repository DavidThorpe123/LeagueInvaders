import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

public class Aliens extends GameObject {

	Aliens(int x, int y, int width, int height) {
		super(x, y, width, height);
	}

	public void draw(Graphics g) {
		g.setColor(Color.CYAN);
		g.fillRect(x, y, width, height);
	}

	public void update() {
		y++;
		int ran = new Random().nextInt(4);
		System.out.println(ran);
		switch (ran) {
		case 0:
			x = x + 2;
			break;
		case 1:
			x = x + 5;
			break;
		case 2:
			x = x - 5;
			break;
		case 3:
			x = x - 2;
			break;
		case 4:
			x = x + 4;
			break;
		}
	}
}
