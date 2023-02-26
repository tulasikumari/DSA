package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class login extends JDialog{

    public static void main(String[] args) {
        JFrame frame = new JFrame("Login Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridBagLayout());

        JLabel userLabel = new JLabel("Username:");
        JTextField userText = new JTextField(20);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(20);
        JButton loginButton = new JButton("Login");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(userLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        frame.add(userText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        frame.add(passLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(passText, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(loginButton, constraints);

//        loginButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String user = userText.getText();
//                String password = new String(passText.getPassword());
//                if (user.equals("admin") && password.equals("admin")) {
//                    JOptionPane.showMessageDialog(null, "Login Successful");
//                } else {
//                    JOptionPane.showMessageDialog(null, "Invalid Login");
//                }
//            }
//        });

        frame.setVisible(true);

    }
}

