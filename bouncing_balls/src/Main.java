import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Program program = new Program();
        program.run();
    }
}

@SuppressWarnings("serial")
class Program extends JFrame implements MouseListener {
    private JFrame mainFrame;
    private DrawPanel drawPanel;
    private java.util.List<Ball> balls;

    private int windowWidth = 640;
    private int windowHeight = 480;
    
    void run() { 	
    	
        balls = new ArrayList<>();
        
        /* Initialize program */
        mainFrame = new JFrame();
        drawPanel = new DrawPanel();
        mainFrame.getContentPane().add(drawPanel);
        mainFrame.setTitle("Bouncing Balls");
        mainFrame.setSize(windowWidth, windowHeight);
        mainFrame.setVisible(true);
        mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        /* Generate balls */
        drawPanel.addMouseListener(this);
        
        while (true) {
            for (Ball b: balls) {
                b.update();
            }

            /* Give Swing 10 milliseconds to see the update! */
            try {
				Thread.sleep(10);
			} catch (InterruptedException i) {
				i.printStackTrace();
			}

            mainFrame.repaint();
        }
    }

	class DrawPanel extends JPanel {
        @Override
        public void paintComponent(Graphics graphics) {
            super.paintComponent(graphics);

            for (Ball b: balls) {
                b.draw(graphics);
            }
        }      
    }

    class Ball {
        private int posX, posY;
        private Color color;

        private int vx = 5;
        private int vy = 5;

        public Ball(int posX, int posY, Color color, int vx, int vy) {
            this.posX = posX;
            this.posY = posY;
            this.color = color;
            this.vx = vx;
            this.vy = vy;
        }

        void update() {
        	
            if (posX >= mainFrame.getWidth() - 20 || posX <= 0) {
                vx *= -1;
            }

            if (posY >= mainFrame.getHeight() - 40 || posY <= 0) {
                vy *= -1;
            }
            
            this.posX += vx;
            this.posY += vy;
        }

        void draw(Graphics g) {
            g.setColor(color);
            g.fillOval(posX, posY, 10, 10);
        }
    }

	@Override
	public void mousePressed(MouseEvent e) {
		/* Random velocities from -5 to 5 */
		int vx = (int) Math.floor((Math.random() * 10) + 1);
		vx = vx > 5 ? vx : -vx;
		
        int vy = (int) Math.floor((Math.random() * 10) + 1);
        vy = vy > 5 ? vy : -vy;
        
        Ball ball = new Ball(
                e.getX(),
                e.getY(),
                /* Random RGB colors */
                new Color(
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256)),
                        (int) Math.floor((Math.random() * 256))
                ),
                vx, vy
        );

        balls.add(ball);		
        
        if (balls.size() == 20)
        	System.out.println("Twenty balls already.");
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}



