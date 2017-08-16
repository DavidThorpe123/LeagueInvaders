import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

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
	final int MENU_STATE = 0;
	final int GAME_STATE = 1;
	final int END_STATE = 2;
	int currentState = MENU_STATE;

	GamePanel() {
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
		System.out.println("Hi");
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
		if (e.getKeyCode() == KeyEvent.VK_ENTER) {
			currentState++;
			if (currentState > END_STATE) {
				currentState = MENU_STATE;
			}
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			om.addObject(new Projectiles(ship.x, ship.y, 10, 10));
		}

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub
		System.out.println("Hi");
	}

	public void updateMenuState() {

	}

	public void updateGameState() {
		om.update();
		om.manageEnemies();
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
