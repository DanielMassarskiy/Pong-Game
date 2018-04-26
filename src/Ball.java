import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Ball extends JPanel{
	public double x;
	public double y;
	public int size;
	public double speed = 1;
	public void paint(Graphics Ball){
		
		Ball.setColor(Color.white);
		Ball.fillOval((int) x, (int) y, size, size);
	}
}
