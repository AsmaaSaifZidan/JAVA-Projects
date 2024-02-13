
package counterapp;

//public class CounterApp {

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class CounterApp {

    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setTitle("Counter");
        MyPanel panel = new MyPanel();
        frame.setContentPane(panel);
        frame.setSize(500, 300);
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}

class MyPanel extends JPanel {
    JButton incBtn;
    JButton decBtn;
    int x;

    public MyPanel() {
        incBtn = new JButton("Increment");
        decBtn = new JButton("Decrement");

        add(incBtn);
        add(decBtn);

        incBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x++;
                repaint();
            }
        });

        decBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                x--;
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawString("x = " + x, 100, 100);
    }
}