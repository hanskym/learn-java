package bab27;
import javax.swing.JFrame;

public class ClientTest1 {
	public static void main(String[] args)
	{
		Client1 application = new Client1();
		application.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		application.waitForPackets();
	}
}
