import java.awt.*;
import java.awt.event.*;
import java.util.PriorityQueue;

import javax.swing.*;

class GameOver extends JDialog{
	private JLabel lb = new JLabel("Score");
	private JLabel scorelb = new JLabel();
	private JButton exitbtn = new JButton("OK");
			
	public GameOver(int score, JumpGame main, InGame inGame) {
		setTitle("Game Over");
		setLayout(new FlowLayout(FlowLayout.CENTER,50,30));
		
		lb.setFont(new Font("Gothic", Font.BOLD, 30));
		scorelb.setFont(new Font("Gothic", Font.BOLD, 30));
		add(lb);
		scorelb.setText(Integer.toString(score));
		add(scorelb);
		add(exitbtn);
		
		setSize(180,250);
		
		exitbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
				main.setVisible(true);
				main.Record(score);
				inGame.dispose();
			}
		});
	}
}