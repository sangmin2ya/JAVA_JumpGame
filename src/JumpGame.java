import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.*;
import java.util.PriorityQueue;

public class JumpGame extends JFrame{
	private MyPanel Menu = new MyPanel();
	private PriorityQueue<Pair> PQ = new PriorityQueue<>(1, new PairComparator());
	private ScoreBoard sb;
	private InGame ig;
	private JButton startBtn = new JButton("Game Start");
	private JButton scoreBtn = new JButton("score board");
	
	private String player;
	
	public JumpGame() {
		super("Jump Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setContentPane(Menu);
		Menu.setLayout(null);
		for(int i = 0; i < 5; i++) {
			PQ.add(new Pair("Empty", 0));
		}
		sb = new ScoreBoard(this, PQ);
		scoreBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				sb.setVisible(true);
			}
		});
	
		ig = new InGame(this);
		
		startBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			player = JOptionPane.showInputDialog("type your name");
			setVisible(false);
			ig.setVisible(true);
			ig.start();
			}
		});
		startBtn.setLocation(430, 600);
		startBtn.setSize(140, 50);
		scoreBtn.setLocation(830, 20);
		scoreBtn.setSize(130, 30);
		Menu.add(startBtn);
		Menu.add(scoreBtn);
			
		setSize(1000,800);
		setVisible(true);
	}
	
	class MyPanel extends JPanel{
		private ImageIcon icon = new ImageIcon("images/Dino_Game.png");
		private Image img = icon.getImage();
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			g.drawImage(img, 0, 0, getWidth(), getHeight(), this);
		}
	}
	public void Record(int score) {
		PQ.add(new Pair(player, score));
		sb = new ScoreBoard(this, PQ);
	}
	public static void main(String[] args) {
		new JumpGame();
	}
}