package bab25;
import javax.swing.JFrame;

public class GridBagDemo {
	public static void main(String[] args)
	{
		GridBagFrame gridBagFrame = new GridBagFrame();
		gridBagFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		gridBagFrame.setSize(300, 150);
		gridBagFrame.setVisible(true);
	}
}
