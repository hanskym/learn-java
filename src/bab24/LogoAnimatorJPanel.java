package bab24;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Graphics;
import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.ServiceManager;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

public class LogoAnimatorJPanel extends JPanel {
	protected ImageIcon images[];
	private int currentImage = 0;
	private final int ANIMATION_DELAY = 50;
	private int width;
	private int height;
	private Timer animationTimer;
	
	public LogoAnimatorJPanel()
	{
		try
		{
			FileOpenService fileOpenService =
					(FileOpenService) ServiceManager.lookup("javax.jnlp.FileOpenService");
			
			FileContents[] contents = fileOpenService.openMultiFileDialog(null, null);
			
			images = new ImageIcon[ contents.length ];
			
			for(int count = 0; count < images.length; count++)
			{
				byte[] imageData = new byte[(int) contents[count].getLength()];
				
				contents[count].getInputStream().read(imageData);
				images[count] = new ImageIcon(imageData);
			}
			
			width = images[0].getIconWidth();
			height = images[0].getIconHeight();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	public void paintComponent(Graphics g)
	{
		super.paintComponent(g);
		
		images[currentImage].paintIcon(this, g, 0, 0);
		
		if(animationTimer.isRunning())
		{
			currentImage = (currentImage + 1) % images.length;
		}
	}
	
	public void startAnimation()
	{
		if(animationTimer == null)
		{
			currentImage = 0;
			
			animationTimer = new Timer(ANIMATION_DELAY, new TimerHandler());
			animationTimer.start();
		}
		else
		{
			if (!animationTimer.isRunning())
			{
				animationTimer.restart();
			}
		}
	}
	
	public void stopAnimation()
	{
		animationTimer.stop();
	}
	
	public Dimension getMinimumSize()
	{
		return getPreferredSize();
	}
	
	public Dimension getPreferredSize()
	{
		return new Dimension(width, height);
	}
	
	private class TimerHandler implements ActionListener
	{
		public void actionPerformed(ActionEvent actionEvent)
		{
			repaint();
		}
	}
}
