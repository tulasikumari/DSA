package View;

import javax.swing.*;
import java.awt.*;

public class HomePageUI extends JFrame {
    private JButton addButton;
    private JButton editButton;
    private JButton deleteButton;

    public HomePageUI() {
        setTitle("My Job Scheduler");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(500, 500);
        setLocationRelativeTo(null);

        JPanel buttonPanel = new JPanel();
        addButton = new JButton("Add Job");
        editButton = new JButton("Edit Job");
        deleteButton = new JButton("Delete Job");

        buttonPanel.add(addButton);
        buttonPanel.add(editButton);
        buttonPanel.add(deleteButton);

        add(buttonPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public static void main(String[] args) {
        new HomePageUI();
    }
}
