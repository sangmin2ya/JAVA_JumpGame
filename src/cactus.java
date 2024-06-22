import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class cactus extends JLabel {
	private ImageIcon cactus = new ImageIcon("images/cactus.png");
	private int CactusX = 1000;
	private boolean end;
	private Thread MoveLeft;
	private Boolean Flag = true;
	public cactus() {
		setLocation(CactusX, 600);
		setSize(150,150);
		setIcon(cactus);
	}
	public void Start() {
		Flag = true;
		CactusX = 1000;
		Move();
	}
	public void Move() {
		MoveLeft = new Thread(new moveleft());
		MoveLeft.start();
	}

	public void Stop() {
		Flag = false;
	}
	class moveleft implements Runnable {
		private int speed = (int)((Math.random()*1000)%10+4);
		@Override
		public void run() {
			while(Flag) {
				try {
					setLocation(CactusX , 600);
					if(!end) {
						CactusX -= speed;
						Thread.sleep(10);
						if(CactusX <= -150) end = true;
					}
					else {
						CactusX = 1000;
						speed = (int)((Math.random()*1000)%5+5);
						end = false;
					}
				}catch(Exception e) {
					return;
				}
			}
		}
	}
}
