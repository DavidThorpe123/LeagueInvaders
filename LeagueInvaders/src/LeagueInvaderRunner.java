import javax.swing.JFrame;

public class LeagueInvaderRunner {
	final static int WIDTH = 500;
	final int HEIGHT = 800;
	JFrame frame;
	GamePanel gp;

	public static void main(String[] args) {
		LeagueInvaderRunner lv = new LeagueInvaderRunner();
	}

	LeagueInvaderRunner() {
		frame = new JFrame();
		gp = new GamePanel();
		frame.addKeyListener(gp);
		setup();
	}

	void setup() {
		gp.startGame();
		frame.add(gp);
		frame.setVisible(true);
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
