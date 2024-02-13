
package datetimeappwiththreads;

import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateTimeAppWithThreads extends JFrame {

    private JLabel dateTimeLabel;

    public DateTimeAppWithThreads() {
        setTitle("Date and Time Display");
        setSize(300, 100);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        dateTimeLabel = new JLabel("", JLabel.CENTER);
        dateTimeLabel.setFont(new Font("Arial", Font.BOLD, 18));

        add(dateTimeLabel);

        // Use SwingWorker to update the date and time in the background
        SwingWorker<Void, String> worker = new SwingWorker<Void, String>() {
            @Override
            protected Void doInBackground() {
                while (true) {
                    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    String formattedDate = dateFormat.format(new Date());
                    publish(formattedDate);

                    try {
                        Thread.sleep(1000); // Sleep for 1 second
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            @Override
            protected void process(java.util.List<String> chunks) {
                // Update the label text in the EDT
                dateTimeLabel.setText(chunks.get(chunks.size() - 1));
            }
        };

        worker.execute(); // Start the background task
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            DateTimeAppWithThreads dateTimeApp = new DateTimeAppWithThreads();
            dateTimeApp.setVisible(true);
        });
    }
}

