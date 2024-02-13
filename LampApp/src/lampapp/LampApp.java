
package lampapp;
import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class LampApp {

    public static void main(String[] args) {
    JFrame frame =new JFrame();
    Panel p =new Panel();
    Thread th = new Thread(p);
      th.start();
     frame.setContentPane(p);
    frame.setSize(500,300);
    frame.setTitle("second app");
    frame.setVisible(true);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


    }
   
}
class Panel extends JPanel implements Runnable {

    private boolean On = true;

    @Override
    public void paint(Graphics g) {
        super.paint(g);

        g.drawOval(100, 100, 150, 30);
        g.drawOval(160, 150, 30, 90);
        g.drawOval(110, 170, 25, 55);
        g.drawOval(215, 170, 25, 55);

        g.drawLine(100, 115, 80, 235);
        g.drawLine(250, 115, 270, 235);
        g.drawArc(80, 205, 190, 60, 0, -180);
        g.drawLine(165, 265, 155, 330);
        g.drawLine(185, 265, 195, 330);

        g.drawRect(115, 330, 120, 15);

        if (On) {
            g.setColor(new Color(255, 255, 153));
        } else {
            g.setColor(Color.gray);
        }

        if (On) {
            g.fillOval(100, 100, 150, 30);
            g.fillOval(160, 150, 30, 90);
            g.fillOval(110, 170, 25, 55);
            g.fillOval(215, 170, 25, 55);
        }
    }

    @Override
    public void run() {
        while (true) {
            On = !On;
            
            try {
                Thread.sleep(700);  
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            repaint();
        }
        
    }
}

















/*g.setColor(Color.yellow);
        g.fillOval(200, 100, 300, 100);
        g.setColor(Color.black);
        g.drawOval(200,100,300, 100);
        g.setColor(Color.black);
        g.drawLine(200, 150, 150, 400);
        g.setColor(Color.black);
        g.drawLine(500, 150, 550, 400);
        g.setColor(Color.black);
        g.drawArc(150, 260, 400, 260, 0, -180);

       
        g.setColor(Color.yellow);
        g.fillOval(270, 250, 150, 150);
        g.setColor(Color.black);
        g.drawOval(270,250,150, 150);
        
        
        
        g.setColor(Color.yellow);
        g.fillOval(180, 270, 70, 70);
        g.setColor(Color.black);
        g.drawOval(180,270,70, 70);
        
        g.setColor(Color.yellow);
        g.fillOval(440, 270, 70, 70);
        g.setColor(Color.black);
        g.drawOval(440,270,70, 70);
        
        g.setColor(Color.black);
        g.drawLine(340, 520, 320, 600);
        g.setColor(Color.black);
        g.drawLine(360, 520, 380, 600);
        
        g.setColor(Color.black);
        g.drawRect(150, 600,400,70);
    }
    
    
    
}
*/