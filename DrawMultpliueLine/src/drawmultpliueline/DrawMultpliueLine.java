
package drawmultpliueline;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawMultpliueLine {

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
    private ArrayList<ArrayList<Point>> lines = new ArrayList<>();
    private ArrayList<Point> currentLine = new ArrayList<>();
    private final int MAX_LINES = 3;

    public MyPanel() {
        this.setBackground(Color.PINK);
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
        for (ArrayList<Point> line : lines) {
            for (int i = 0; i < line.size() - 1; i += 4) {
                Point p1 = line.get(i);
                Point p2 = line.get(i + 1);
                g.drawLine(p1.x, p1.y, p2.x, p2.y);
            }
        }
    }

    private class MyMouseListener extends MouseAdapter {
        private Point startPoint;

        @Override
        public void mousePressed(MouseEvent e) {
            if (lines.size() < MAX_LINES) {
                startPoint = e.getPoint();
                currentLine.clear();
                currentLine.add(startPoint);
            }
        }

        @Override
        public void mouseReleased(MouseEvent e) {
            if (lines.size() < MAX_LINES && !currentLine.isEmpty()) {
                currentLine.add(e.getPoint());
                lines.add(new ArrayList<>(currentLine));
                currentLine.clear();
                repaint();
            }
        }

        @Override
       
        public void mouseDragged(MouseEvent e) {
        if (lines.size() < MAX_LINES) {
        try {
            currentLine.set(1, e.getPoint());
            repaint();
        } catch (IndexOutOfBoundsException ex) {
            // If currentLine has less than 2 elements, catch the exception and ignore
            // You can add logging or other error handling here if needed
        }
    }
}

    }
}    