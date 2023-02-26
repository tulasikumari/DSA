package View;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignupPage extends JDialog {

    public static void main(String[] args) {
        JFrame frame = new JFrame("Signup Page");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(500, 500);
        frame.setLayout(new GridBagLayout());

        JLabel nameLabel = new JLabel("Name:");
        JTextField nameText = new JTextField(20);
        JLabel addressLabel = new JLabel("Address:");
        JTextArea addressText = new JTextArea(3, 20);
        JLabel phoneLabel = new JLabel("Phone No.:");
        JTextField phoneText = new JTextField(20);
        JLabel passLabel = new JLabel("Password:");
        JPasswordField passText = new JPasswordField(20);
        JButton signupButton = new JButton("Sign Up");

        GridBagConstraints constraints = new GridBagConstraints();
        constraints.insets = new Insets(10, 10, 10, 10);
        constraints.fill = GridBagConstraints.HORIZONTAL;

        constraints.gridx = 0;
        constraints.gridy = 0;
        frame.add(nameLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 0;
        frame.add(nameText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 1;
        frame.add(addressLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 1;
        frame.add(addressText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 2;
        frame.add(phoneLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 2;
        frame.add(phoneText, constraints);

        constraints.gridx = 0;
        constraints.gridy = 3;
        frame.add(passLabel, constraints);

        constraints.gridx = 1;
        constraints.gridy = 3;
        frame.add(passText, constraints);

        constraints.gridx = 1;
        constraints.gridy = 4;
        frame.add(signupButton, constraints);

//        signupButton.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String name = nameText.getText();
//                String address = addressText.getText();
//                String phone = phoneText.getText();
//                String password = new String(passText.getPassword());
//                // validate inputs and create new user in database
//            }
//        });

        frame.setVisible(true);
    }
}
