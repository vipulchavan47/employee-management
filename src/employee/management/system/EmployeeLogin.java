package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

public class EmployeeLogin extends JFrame implements ActionListener {
    JTextField tusername;
    JPasswordField tpassword;
    JButton login, back;

    EmployeeLogin() {
        // Create the Employee Login frame
        setTitle("Employee Login");
        setSize(400, 300);
        setLocationRelativeTo(null); // Center the frame on the screen
        setLayout(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(Color.getHSBColor(185, 185, 185));

        // Username Label and TextField
        JLabel username = new JLabel("Username");
        username.setBounds(50, 60, 100, 30);
        add(username);

        tusername = new JTextField();
        tusername.setBounds(150, 60, 150, 30);
        add(tusername);

        // Password Label and PasswordField
        JLabel password = new JLabel("Password");
        password.setBounds(50, 100, 100, 30);
        add(password);

        tpassword = new JPasswordField();
        tpassword.setBounds(150, 100, 150, 30);
        add(tpassword);

        // Login Button
        login = new JButton("LOGIN");
        login.setBounds(150, 140, 150, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);

        // Back Button
        back = new JButton("BACK");
        back.setBounds(150, 180, 150, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);



        // Load the Login frame
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/LoginB.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel img = new JLabel(i3);
        img.setBounds(0, 0, 600, 300);
        add(img);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == login) {
            try {
                String username = tusername.getText();
                String password = new String(tpassword.getPassword()); // Get password as a String

                conn conn = new conn();

                String query = "select * from employee_login where emp_username = '" + username + "' and emp_password = '" + password + "'";
                ResultSet resultSet = conn.statement.executeQuery(query);
                if (resultSet.next()) {
                    setVisible(false);
                    new EmployeeDashboard(username);
                } else {
                    JOptionPane.showMessageDialog(null, "Invalid Username or Password");
                }
            } catch (Exception E) {
                E.printStackTrace();
            }
        } else if (e.getSource() == back) {
//            System.exit(0);
            setVisible(false);
            new Login();
        } else if (e.getActionCommand().equals("Employee Login")) {
            // This section is for additional logic specific to employee authentication
            // You can add your authentication logic here
        }
    }

    public static void main(String args[]) {
        new EmployeeLogin();
    }
}
