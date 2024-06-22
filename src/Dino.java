import javax.swing.*;

public class Dino extends JLabel {
	
	private ImageIcon normal1 = new ImageIcon("images/Dino1.png");
	private ImageIcon normal2 = new ImageIcon("images/Dino2.png");
	private ImageIcon surprise = new ImageIcon("images/Dino3.png");
	private ImageIcon jump = new ImageIcon("images/Dino_Jump.png");
	private Boolean JumpFlag = true;
	private Boolean WalkFlag = true;
	private int DinoY = 600;
	private Thread walk;
	private Thread jumpUp;
	public Dino() {
		setLocation(200,600);
		setSize(150,150);
		setIcon(normal1);
	}
	public void Start() {
		JumpFlag = true;
		WalkFlag = true;
		setIcon(normal1);
		DinoY = 600;
		setLocation(200,600);
		Walk();
	}
	public void Jump() {
		jumpUp = new Thread(new JumpUp());
		if(JumpFlag) {
			jumpUp.start();
		}
	}
	public void Walk() {
		walk = new Thread(new Walk());
		walk.start();
	}
	public void Stop() {	
		JumpFlag = false;
		WalkFlag = false;
		if(jumpUp != null) jumpUp.interrupt();
		walk.interrupt();
		setIcon(surprise);
	}
	class Walk implements Runnable{
		@Override
		public void run() {
			while(WalkFlag) {
				try {
					if(!JumpFlag)
						continue;
					setIcon(normal2);
					Thread.sleep(300);
					setIcon(normal1);
					Thread.sleep(300);

				}catch(Exception e) {
					return;
				}
			}
		}
	}
	class JumpUp implements Runnable {
		private Boolean OnAir = true;
		private boolean direction = true;
		@Override
		public void run() {
			JumpFlag = false; 
			while(OnAir) {
				try {
					setIcon(jump);
					setLocation(200, DinoY);
					if(DinoY <= 200) {
						direction = false;
					}
					
					if(direction) {
						DinoY -= 6;
						Thread.sleep(8);
					}
					else {
						DinoY += 6;
						Thread.sleep(8);
					}
					if(DinoY >= 600) {
						DinoY = 600;
						OnAir = false;
						JumpFlag = true;
					}
				} catch(Exception e) {
					return;
				}
			}
			Walk();
			
		};
	}
}
