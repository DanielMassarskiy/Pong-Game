import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JPanel;
import java.awt.Frame;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.*;
import java.awt.Font;
import javax.swing.SwingConstants;

public class pong {
	
	
	
	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					pong window = new pong();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public pong() {
		
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	public double xStep = 1;
	public double yStep = 1;
	Player player_1 = new Player();
	Player player_2 = new Player();
	
	private void initialize() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		final Timer timer = new Timer();
		final int width = screenSize.width;
		final int height = screenSize.height;
		
		frame = new JFrame("Pong");
		frame.setBounds(0, 0, width, height);
		frame.setExtendedState(Frame.MAXIMIZED_BOTH);
		frame.setUndecorated(true);
		System.out.println(width  + " " + height);
		
		final Ball ball = new Ball();
		ball.setBounds(0, 0, width, height);
		
		final Paddle paddle1 = new Paddle();
		paddle1.setBounds(0, 0, width, height);
		
		final Paddle paddle2 = new Paddle();
		paddle2.setBounds(0, 0, width, height);
		
		ball.size = height / 30;
		ball.x = width / 2 - 15;
		ball.y = height / 2 - 15;
		paddle1.height = height / 5;
		paddle1.width = width/80;
		paddle1.x = 0;
		paddle1.y = height / 2 - 70;
		paddle2.height = height / 5;
		paddle2.width = width/80;
		paddle2.x = width - paddle2.width;
		paddle2.y = height / 2 - 70;
		
		
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent arg0) {
				if(arg0.getKeyCode() == KeyEvent.VK_UP)
				{
					if(paddle2.y > 0)
						paddle2.y -= 10;
					frame.repaint();
				}
				else if(arg0.getKeyCode() == KeyEvent.VK_DOWN)
				{
					if(paddle2.y <= height - paddle2.height)
						paddle2.y += 10;
					frame.repaint();
				}
				if(arg0.getKeyCode() == KeyEvent.VK_ESCAPE)
				{
					timer.cancel();
					frame.dispose();
				}

			}
		});
		
		frame.addKeyListener(new KeyAdapter() {
			public void keyPressed(KeyEvent e) {
				if(e.getKeyCode() == KeyEvent.VK_W)
				{
  
					if(paddle1.y > 0)
						paddle1.y -= 10;
					frame.repaint();
					
				}
				else if(e.getKeyCode() == KeyEvent.VK_S)
				{
					if(paddle1.y < height - paddle1.height)
						paddle1.y += 10; 
					frame.repaint();
				}

			}
		});
		
		
		frame.setFocusable(true);
		
		System.out.println(paddle2.y);
		
		frame.getContentPane().setLayout(null);
		
		final JLabel label = new JLabel();
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Comic Sans MS", Font.PLAIN, 40));
		label.setBounds(width/2 - 40, height*1/18, 80, 80);
		frame.getContentPane().add(label);
		
		
		
		frame.getContentPane().add(ball);
		frame.getContentPane().add(paddle1);
		frame.getContentPane().add(paddle2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.BLACK);
		panel_1.setBounds(0, 0, width, height);
		
		
		
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		timer.schedule(new TimerTask(){
			@Override
				public void run(){
					ball.x = ball.x + xStep;
					ball.y = ball.y + yStep;
					label.setText("<html>" + player_1.score + ":" + player_2.score +"</html>");
					if(ball.y < 0 || ball.y > height - ball.size)
					{
						yStep = -yStep;
					}
					else if(/**/ball.x <= paddle1.x + paddle1.width && ball.y >= paddle1.y && ball.y <= paddle1.y + paddle1.height || ball.x >= paddle2.x - ball.size && ball.y >= paddle2.y && ball.y <= paddle2.y + paddle2.height)
					{
						xStep = -xStep;
						if(xStep < 0)
						{
							xStep -= 2;
						}
						else if(xStep > 0)
						{
							xStep += 2;
						}
						if(yStep < 0)
						{
							yStep -= 2;
						}
						else if(yStep > 0)
						{
							yStep += 2;
						}
					}
					else if(ball.x < 0 || ball.x > width - ball.size)
					{
						if(ball.x < 0)
						{
							player_2.score++;
						}
						else if(ball.x > width - ball.size)
						{
							player_1.score++;
						}
						ball.x = width/2;
						ball.y = height/2;
						yStep = 1;
						xStep = 1;
					}
					if(player_1.score == 10 || player_2.score == 10)
					{
						timer.cancel();
						frame.dispose();
					}
					frame.repaint();
				}
		}, 1, 1);	
	}
}
