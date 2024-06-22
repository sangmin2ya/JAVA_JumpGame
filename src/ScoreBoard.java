import java.awt.*;
import java.awt.event.*;
import java.util.Iterator;
import java.util.PriorityQueue;

import javax.swing.*;

class ScoreBoard extends JDialog{
	private JButton btn = new JButton("close");
	public ScoreBoard(JFrame frame, PriorityQueue<Pair> PQ) {
		setTitle("ScoreBoard");
			
		setLayout(new GridLayout(13,2));
		add(new JLabel("NAME"));
		add(new JLabel("SCORE"));
		
		Iterator<Pair> iter = PQ.iterator();
		for(int i = 0; i< 5; i++){
			Pair p = iter.next();
			add(new JLabel(p.name));
			add(new JLabel(Integer.toString(p.score)));
		}
		add(new JLabel());
		add(btn);
		setSize(200,300);
		
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		
	}
}