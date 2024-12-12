package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class EmployeeDashboard extends JFrame {
    private String empID;

    public EmployeeDashboard(String empID) {
        this.empID = empID;

        // Set frame dimensions
        setBounds(400, 200, 600, 400); // Adjusted frame size
        setTitle("Employee Dashboard");

        // Create a panel
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(212, 230, 241)); // Background color

        // Create a welcome label
        JLabel welcomeLabel = new JLabel("Welcome, Team Member");
        welcomeLabel.setBounds(150, 30, 300, 30);
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18)); // Set font
        panel.add(welcomeLabel);

        // Create Show Details button
        JButton showDetailsButton = new JButton("Show Details");
        showDetailsButton.setFont(new Font("Arial", Font.PLAIN, 14));
        showDetailsButton.setBackground(new Color(23, 32, 42)); // Button background color
        showDetailsButton.setForeground(Color.WHITE); // Button text color
        showDetailsButton.setBounds(200, 150, 200, 30); // Set button position and size
        showDetailsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new EmployeeDetailsFrame(empID); // Assuming you have an EmployeeDetailsFrame class
            }
        });
        panel.add(showDetailsButton);

        // Create Logout button
        JButton logoutButton = new JButton("Logout");
        logoutButton.setBounds(225, 250, 150, 30);
        logoutButton.setForeground(Color.WHITE);
        logoutButton.setBackground(Color.BLACK);
        logoutButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    dispose(); // Close the current frame
                    new EmployeeLogin(); // Open the Login frame
                }
            }
        });
        panel.add(logoutButton);

        // Add the panel to the frame
        add(panel);

        // Set frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame on the screen
        setVisible(true);
    }

    public static void main(String[] args) {
        new EmployeeDashboard("empID"); // Replace "empID" with the actual employee ID
    }
}
