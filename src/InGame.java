import java.awt.event.*;
import java.awt.*;
import javax.swing.*;
import java.util.*;
import javax.swing.*;

public class InGame extends JFrame{
	private Dino Dino;
	private cactus Cactus;
	private JLabel Scorelb = new JLabel();
	private GameOver go;
	private PosCheck pc;
	private Score sc;
	public InGame(JFrame frame) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Gaming...");
		getContentPane().setBackground(Color.white);
		setLayout(null);
		
		addKeyListener(new MyKeyListener());
		Dino = new Dino();
		Cactus = new cactus();
		sc = new Score(Scorelb);
		Scorelb.setLocation(850, 20);
		Scorelb.setSize(200,50);
		Scorelb.setFont(new Font("Gothic", Font.BOLD, 30));
		
		pc = new PosCheck(this, frame ,Dino, Cactus, sc);
		
		
		
		setSize(1000,800);
	}
	class MyKeyListener extends KeyAdapter{
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_SPACE) {
				Dino.Jump();
			}
		}
	}
	public void start() {
		Dino.Start();
		Cactus.Start();
		sc.Start();
		add(Scorelb);
		add(Dino);
		add(Cactus);
		
		pc.Check();
	}
}
