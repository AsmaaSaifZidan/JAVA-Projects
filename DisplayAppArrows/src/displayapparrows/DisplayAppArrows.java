
package displayapparrows;

//public class DisplayAppArrows {

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DisplayAppArrows {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Moving String");
        MyPanel panel = new MyPanel ();
        frame.setContentPane(panel);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        panel.requestFocusInWindow(); 
    }
}

class MyPanel extends JPanel implements KeyListener {
    private int x = 250; 
    private int y = 150; 
    private String message = "Hello"; 

    public MyPanel() {
        addKeyListener(this); 
        setFocusable(true); 
        setFocusTraversalKeysEnabled(false); 
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLUE);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        g.drawString(message, x, y);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        int keyCode = e.getKeyCode();
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                x -= 10;
                break;
            case KeyEvent.VK_RIGHT:
                x += 10;
                break;
            case KeyEvent.VK_UP:
                y -= 10;
                break;
            case KeyEvent.VK_DOWN:
                y += 10;
                break;
        }
        repaint(); 
    }
  @Override
    public void keyTyped(KeyEvent e) {
        // Not used, but required by the KeyListener interface
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // Not used, but required by the KeyListener interface
    }
  
}

