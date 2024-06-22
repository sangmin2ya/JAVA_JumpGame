import javax.swing.*;

public class PosCheck {
	private Dino Dino;
	private cactus Cactus;
	private Double Distance;
	private GameOver go;
	private Score sc;
	private InGame inGame;
	private JumpGame main;
	public PosCheck(JFrame inGame, JFrame main, Dino d, cactus c, Score sc) {
		this.Dino = d;
		this.Cactus = c;
		this.go = go;
		this.sc = sc;
		this.inGame = (InGame) inGame;
		this.main = (JumpGame) main;
	}
	public void Check() {
		Thread Checkthr = new Thread(new Check());
		Checkthr.start();
	}
	class Check implements Runnable{
		private double xd;
		private double yd;
		@Override
		public void run() {
			while(true) {
				xd = Math.pow(Dino.getX()-Cactus.getX(),2);
				yd = Math.pow(Dino.getY()-Cactus.getY(),2);
				Distance = Math.sqrt(yd+xd);
				if(Distance < 150) {
					go = new GameOver(sc.getScore(), main, inGame);
					Dino.Stop();
					Cactus.Stop();
					sc.Stop();
					go.setVisible(true);
					break;
				}
			}
			
		}
		
	}
}
