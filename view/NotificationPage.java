package view;

import view.components.Myframe;
import javax.swing.*;
import java.awt.*;

public class NotificationPage extends Myframe{
    public NotificationPage(String message) {
        super("Notification", 150, 1000);
        JLabel notificationMessage = new JLabel(message);
        notificationMessage.setFont(new Font("Arial", Font.BOLD, 14));

        JPanel panel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.insets = new Insets(10, 10, 10, 10); 
        panel.add(notificationMessage, gbc);

        add(panel, BorderLayout.CENTER);

        setLocationRelativeTo(null); 
        setResizable(false);
        setVisible(true);
    }
}
