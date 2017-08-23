import java.awt.Graphics;
import java.awt.Rectangle;

public class GameObject {
	int x = 50;
	int y = 200;
	int width = 50;
	int height = 50;
	Rectangle collisionBox;
	Boolean isAlive = true;

	GameObject(int x, int y, int width, int height) {
		this();
		this.x = x;
		this.y = y;
		this.height = height;
		this.width = width;
		collisionBox = new Rectangle(x, y, width, height);
	}

	public GameObject() {
		// TODO Auto-generated constructor stub
	}

	public void update() {
		if (collisionBox != null) {
			collisionBox.setBounds(x, y, width, height);
		}

	}

	public void draw(Graphics g) {
		g.drawRect(x, y, width, height);
	}
}
