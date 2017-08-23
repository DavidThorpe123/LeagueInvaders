import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener, KeyListener {
	Font start;
	Font titlefont;
	Font instructions;
	Font gameover;
	Font backspace;
	Rocketship ship;
	ObjectManager om;
	Timer timer;
	GameObject go;
	public static BufferedImage alienimg;
	public static BufferedImage rocketimg;
	public static BufferedImage bulletimg;
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
		try {
			alienimg = ImageIO.read(this.getClass().getResourceAsStream("alien.png"));
			rocketimg = ImageIO.read(this.getClass().getResourceAsStream("rocket.png"));
			bulletimg = ImageIO.read(this.getClass().getResourceAsStream("bullet.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		timer = new Timer(1000 / 60, this);
		titlefont = new Font("Arial", Font.PLAIN, 48);
		instructions = new Font("Arial", Font.PLAIN, 28);
		start = new Font("Arial", Font.PLAIN, 28);
		gameover = new Font("Arial", Font.PLAIN, 48);
		backspace = new Font("Arial", Font.PLAIN, 28);
		ship = new Rocketship(250, 700, 50, 50);
		go = new GameObject();
		om = new ObjectManager();
		om.addObject(ship);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		go.update();
		repaint();
		if (currentState == MENU_STATE) {
			updateMenuState();
		} else if (currentState == GAME_STATE) {
			updateGameState();
		} else if (currentState == END_STATE) {
			updateEndState();
		}
	}

	public void startGame() {
		timer.start();
	}

	public void paintComponent(Graphics g) {
		if (currentState == MENU_STATE) {
			drawMenuState(g);
		} else if (currentState == GAME_STATE) {
			drawGameState(g);
		} else if (currentState == END_STATE) {
			drawEndState(g);
		}
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.addObject(new Projectiles(ship.x, ship.y, 10, 10));
		}
		if (e.getKeyCode() == KeyEvent.VK_A) {
			ship.x -= 10;
			if (ship.x < 0) {
				ship.x = 500;
			}

		}
		if (e.getKeyCode() == KeyEvent.VK_D) {
			ship.x += 10;
			if (ship.x > 500) {
				ship.x = 5;
			}
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		om.update();
		om.manageEnemies();
		om.checkCollision();
		if (!ship.isAlive) {
			om.reset();
			ship = new Rocketship(250, 700, 50, 50);
			om.addObject(ship);
			currentState = END_STATE;
		}
	}

	public void updateEndState() {

	}

	void drawMenuState(Graphics g) {
		g.setColor(Color.ORANGE);
		g.setFont(titlefont);
		g.drawString("LeagueInvaders", 80, 125);
		g.setFont(start);
		g.drawString("Press Enter to Start", 125, 200);
		g.setFont(start);
		g.drawString("Press Space for Instructions", 85, 275);

	}

	void drawGameState(Graphics g) {
		om.draw(g);
	}

	void drawEndState(Graphics g) {
		g.setColor(Color.orange);
		g.setFont(gameover);
		g.drawString("Game Over", 115, 150);
		g.setFont(backspace);
		g.drawString("Press BACKSPACE to Restart", 75, 600);
	}
}
