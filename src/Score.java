import javax.swing.*;

public class Score {
	private int Score = 0;
	private JLabel ScoreLabel;
	private Thread CheckScore;
	private boolean Flag = true;
	public Score(JLabel score) {
		this.ScoreLabel = score;
	}
	public void Start() {
		Score = 0;
		Flag = true;
		startScore();
	}
	public int getScore() {
		return Score;
	}
	public void Stop() {
		CheckScore.interrupt();
		Flag = false;
	}
	public void startScore() {
		CheckScore = new Thread(new score());
		CheckScore.start();
	}
	class score implements Runnable{
		@Override
		public void run() {
			while(Flag) {
				Score++;
				ScoreLabel.setText(Integer.toString(Score));
				try {
					Thread.sleep(100);
				} catch (Exception e) {
					e.printStackTrace();
				}
				}
			}
		}
	}
