package goalin;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Goal {
	JFrame frame = new JFrame("Goal-in");
	int WIDTH = 800;
	int HEIGHT = 480;
	int x = 100, y = 100;
	int radius = 5;
	int speed = 1;
	
	ArrayList<Jewel> jewels = new ArrayList<>();
	Home home = new Home();
	
	public Goal() {
		frame.setSize(WIDTH, HEIGHT);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		frame.getContentPane().add(new GamePanel());
		frame.addKeyListener(new GameKeyListener());
		
		frame.setVisible(true);
	}
	public boolean go() {
		for (int i = 0; i < 100; i++) {
			jewels.add(new Jewel());
		}
		
		while (true) {
			
			Iterator<Jewel> alba = jewels.iterator();
			while (alba.hasNext()) {
				Jewel jewel = alba.next();
				double distance = Math.sqrt((x - jewel.getX()) * (x - jewel.getX()) + (y - jewel.getY()) * (y - jewel.getY()));
				double distance2 = Math.sqrt((home.getX() - jewel.getX()) * (home.getX() - jewel.getX())
						+ (home.getY() - jewel.getY()) * (home.getY() - jewel.getY()));
				double distance3 = Math.sqrt((x - home.getX()) * (x - home.getX()) + (y - home.getY()) * (y - home.getY()));
					
				if(distance2 <= home.getRadius()) {
					alba.remove();
				}
				if(distance3 <= radius)  {
					return false;
				}
				
				if (distance <= radius) {
					return false;
				}
			}
			
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			frame.repaint();
		}
	}
	
	class GamePanel extends JPanel {
		public void paintComponent(Graphics g) {
			super.paintComponent(g);
			
			for (Jewel jewel : jewels) {
				g.setColor(Color.BLACK);
				g.fillRect(jewel.getX(), jewel.getY(), jewel.getWidth(), jewel.getWidth());
			}
			
			g.setColor(Color.YELLOW);
			g.fillOval(home.getX(), home.getY(), home.getRadius(), home.getRadius());
			
			g.setColor(Color.GREEN);
			g.fillOval(x, y, 2*radius, 2*radius);
		}
	}
	
	private class Home {
		int x = 0;
		int y = 0;
		int radius = 25;
		
		public Home() {
			x = (int)(Math.random() * WIDTH);
			y = (int)(Math.random() * HEIGHT);
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getRadius() {
			return radius;
		}
	}
	
	private class Jewel {
		int x = 0;
		int y = 0;
		int width = 20;
		
		public Jewel() {
			x = (int)(Math.random() * WIDTH);
			y = (int)(Math.random() * HEIGHT);
		}

		public int getX() {
			return x;
		}

		public int getY() {
			return y;
		}

		public int getWidth() {
			return width;
		}
	}
	
	class GameKeyListener implements KeyListener {

		@Override
		public void keyTyped(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}

		@Override
		public void keyPressed(KeyEvent e) {
			// TODO Auto-generated method stub
			switch (e.getKeyCode()) {
				case KeyEvent.VK_UP:
					y--;
					break;
				case KeyEvent.VK_RIGHT:
					x++;
					break;
				case KeyEvent.VK_LEFT:
					x--;
					break;
				case KeyEvent.VK_DOWN:
					y++;
					break;
				
		}
		
		}
		@Override
		public void keyReleased(KeyEvent e) {
			// TODO Auto-generated method stub
			
		}
		
	}
}
