package bab18;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JColorChooser;

public class Fractal extends JFrame {
	private static final int WIDTH = 400;
	private static final int HEIGHT = 480;
	private static final int MIN_LEVEL = 0, MAX_LEVEL = 15;
	
	private JButton changeColorJButton, increaseLevelJButton, decreaseLevelJButton;
	private JLabel levelJLabel;
	private FractalJPanel drawSpace;
	private JPanel mainJPanel, controlJPanel;
	
	public Fractal()
	{
		super("Fractal");
		
		controlJPanel = new JPanel();
		controlJPanel.setLayout(new FlowLayout());
		
		changeColorJButton = new JButton("Color");
		controlJPanel.add(changeColorJButton);
		changeColorJButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				Color color = JColorChooser.showDialog(
						Fractal.this, "Choose a color", Color.BLUE);
				
				if(color == null)
				{
					color = Color.BLUE;
				}
				
				drawSpace.setColor(color);
			}
		});
		
		decreaseLevelJButton = new JButton("Decrease Level");
		controlJPanel.add(decreaseLevelJButton);
		decreaseLevelJButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int level = drawSpace.getLevel();
				--level;
				
				if((level >= MIN_LEVEL) && (level <= MAX_LEVEL))
				{
					levelJLabel.setText("Level: " + level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		});
		
		increaseLevelJButton = new JButton("Increase Level");
		controlJPanel.add(increaseLevelJButton);
		increaseLevelJButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent event)
			{
				int level = drawSpace.getLevel();
				++level;
				
				if((level >= MIN_LEVEL) && (level <= MAX_LEVEL))
				{
					levelJLabel.setText("Level: " + level);
					drawSpace.setLevel(level);
					repaint();
				}
			}
		});
		
		levelJLabel = new JLabel("Level: 0");
		controlJPanel.add(levelJLabel);
		
		drawSpace = new FractalJPanel(0);
		
		mainJPanel = new JPanel();
		mainJPanel.add(controlJPanel);
		mainJPanel.add(drawSpace);
		
		add(mainJPanel);
		
		setSize(WIDTH, HEIGHT);
		setVisible(true);
	}
	
	public static void main(String[] args)
	{
		Fractal demo = new Fractal();
		demo.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
