package bab27;
import javax.swing.JFrame;

public class ServerTest1 {
	public static void main(String[] args)
	{
		Server1 application = new Server1();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.waitForPackets();
	}
}
