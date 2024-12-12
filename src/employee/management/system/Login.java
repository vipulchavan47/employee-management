package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class Login extends JFrame implements ActionListener {

    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back, empLoginButton;

    // Constructor
    Login() {
        // Set the frame title
        setTitle("Employee Management System");

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the frame dimensions
        setBounds(100, 100, 600, 400);

        // Set the layout to null for custom positioning
        getContentPane().setLayout(null);

        // Create the "Username" label
        JLabel username = new JLabel("Username");
        username.setBounds(40, 20, 100, 30);
        add(username);

        // Create the text field for username
        tusername = new JTextField();
        tusername.setBounds(150, 20, 150, 30);
        add(tusername);

        // Create the "Password" label
        JLabel password = new JLabel("Password");
        password.setBounds(40, 70, 100, 30);
        add(password);

        // Create the password field
        tpassword = new JPasswordField();
        tpassword.setBounds(150, 70, 150, 30);
        add(tpassword);

        // Create the "LOGIN" button
        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);

        // Create the "BACK" button
        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        add(back);


        // Create the "Employee Login" button
        empLoginButton = new JButton("Employee Login");
        empLoginButton.setBounds(150, 220, 150, 30);
        empLoginButton.setBackground(Color.BLACK);
        empLoginButton.setForeground(Color.WHITE);
        empLoginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Close the current Login frame
                dispose();

                new EmployeeLogin(); // Open the Employee Login panel
            }
        });
        add(empLoginButton);


// Load and set an image as the background
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(getWidth(), getHeight(), Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, getWidth(), getHeight());
        add(img);

        // Make the frame visible
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = new String(tpassword.getPassword());

                conn conn = new conn();

                String query = "select * from login where username = '" + username + "' and password = '" + password + "'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()) {
                    setVisible(false);
                    new Main_class();
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }

            } catch (Exception E) {
                E.printStackTrace();
            }
        }

        else if (e.getSource() == back) {
            System.exit(0);
        }
    }

    public static void main(String args[]) {
        new Login();
    }
}
