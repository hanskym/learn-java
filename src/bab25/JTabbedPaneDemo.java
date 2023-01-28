package bab25;
import javax.swing.JFrame;

public class JTabbedPaneDemo {
	public static void main(String[] args)
	{
		JTabbedPaneFrame tabbedPaneFrame = new JTabbedPaneFrame();
		tabbedPaneFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tabbedPaneFrame.setSize(250, 200);
		tabbedPaneFrame.setVisible(true);
	}
}
