package bab24;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.jnlp.FileContents;
import javax.jnlp.FileOpenService;
import javax.jnlp.ServiceManager;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class LoadImageAndScale extends JApplet {
	private ImageIcon image;
	private JPanel scaleJPanel;
	private JLabel percentJLabel;
	private JTextField scaleInputJTextField;
	private JButton scaleChangeJButton;
	private double scaleValue = 1.0;
	
	public void init()
	{
		scaleJPanel = new JPanel();
		percentJLabel = new JLabel("scale percent:");
		scaleInputJTextField = new JTextField("100");
		scaleChangeJButton = new JButton("Set Scale");
		
		scaleJPanel.add(percentJLabel);
		scaleJPanel.add(scaleInputJTextField);
		scaleJPanel.add(scaleChangeJButton);
		add(scaleJPanel, BorderLayout.NORTH);
		
		scaleChangeJButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				scaleValue = Double.parseDouble(scaleInputJTextField.getText()) / 100.0;
				repaint();
			}
		});
		
		try
		{
			FileOpenService fileOpenService = (FileOpenService) ServiceManager.lookup(
					"javax.jnlp.FileOpenService");
			
			FileContents contents = fileOpenService.openFileDialog(null, null);
			
			byte[] imageData = new byte[(int) contents.getLength()];
			contents.getInputStream().read(imageData);
			image = new ImageIcon(imageData);
			
			add(new DrawJPanel(), BorderLayout.CENTER);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	
	private class DrawJPanel extends JPanel
	{
		public void paintComponent(Graphics g)
		{
			super.paintComponent(g);
			
			double spareWidth = getWidth() - scaleValue * image.getIconWidth();
			double spareHeight = getHeight() - scaleValue * image.getIconHeight();
			
			g.drawImage(image.getImage(),
					(int) (spareWidth ) / 2, (int) (spareHeight) / 2,
					(int) (image.getIconWidth() * scaleValue),
					(int) (image.getIconHeight() * scaleValue), this);
		}
	}
}
