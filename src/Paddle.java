import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JComponent;
import javax.swing.JPanel;

public class Paddle extends JPanel{
	public int x;
	public int y;
	public int width;
	public int height;
	public void paint(Graphics Paddle){
		Paddle.clearRect(x, y, width, height);
		Paddle.setColor(Color.white);
		Paddle.fillRect(x, y, width, height);
	}
	
	
}
