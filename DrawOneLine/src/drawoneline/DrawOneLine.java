
package drawoneline;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawOneLine {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Drawing Line");
        MyPanel panel = new MyPanel();
        frame.setContentPane(panel);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel {
    private ArrayList<Point> points = new ArrayList<>();
    
    public MyPanel() {
        MyMouseListener listener = new MyMouseListener();
        addMouseListener(listener);
        addMouseMotionListener(listener);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(Color.BLACK);
        g.setFont(new Font("Arial", Font.BOLD, 24));
        
        // Draw lines
        for (int i = 0; i < points.size() - 1; i += 2) {
            Point p1 = points.get(i);
            Point p2 = points.get(i + 1);
            g.drawLine(p1.x, p1.y, p2.x, p2.y);
        }
    }
    
    private class MyMouseListener extends MouseAdapter {
        private Point startPoint;
        
        @Override
        public void mousePressed(MouseEvent e) {
            startPoint = e.getPoint();
        }
        
        @Override
        public void mouseReleased(MouseEvent e) {
            points.add(startPoint);
            points.add(e.getPoint());
            repaint();
        }
        
        @Override
        public void mouseDragged(MouseEvent e) {
            if (!points.isEmpty()) {
                points.remove(points.size() - 1);
                points.remove(points.size() - 1);
                repaint();
            }
        }
    }
}

