package employee.management.system;

import javax.swing.*;
import java.awt.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeDetailsFrame extends JFrame {
    private String employeeID;
    private JTextArea detailsArea;

    public EmployeeDetailsFrame(String empID) {
        this.employeeID = empID;

        setTitle("Employee Details");
        setBounds(100, 100, 600, 400);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        getContentPane().setBackground(new Color(240, 248, 255)); // Set background color

        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        panel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        panel.setBackground(new Color(240, 248, 255)); // Set panel background color

        detailsArea = new JTextArea();
        detailsArea.setEditable(false);
        detailsArea.setFont(new Font("Arial", Font.PLAIN, 14));
        detailsArea.setBackground(new Color(255, 255, 255)); // Set text area background color
        JScrollPane scrollPane = new JScrollPane(detailsArea);
        panel.add(scrollPane, BorderLayout.CENTER);

        // Fetch and display employee details
        fetchAndDisplayDetails();

        getContentPane().add(panel, BorderLayout.CENTER);

        // Create a back button
        JButton backButton = new JButton("Back to Dashboard");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBackground(new Color(75, 119, 190)); // Set button background color
        backButton.setForeground(Color.WHITE); // Set button text color
        backButton.addActionListener(e -> {
            // Code to navigate back to the dashboard
            dispose(); // Close the current frame
            new EmployeeDashboard(employeeID); // Open the dashboard with the employee ID
        });

        // Create a panel for the back button
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setBackground(new Color(240, 248, 255)); // Set panel background color
        buttonPanel.add(backButton);
        getContentPane().add(buttonPanel, BorderLayout.SOUTH);

        setVisible(true);
    }

    private void fetchAndDisplayDetails() {
        conn connection = new conn();
        try {
            Connection conn = connection.connection;
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM employee WHERE empID = '" + employeeID + "'");
            StringBuilder details = new StringBuilder();
            while (rs.next()) {
                details.append("Name: ").append(rs.getString("name")).append("\n\n");
                details.append("Surname: ").append(rs.getString("fname")).append("\n\n");
                details.append("Date of Birth: ").append(rs.getString("dob")).append("\n\n");
                details.append("Salary: $").append(rs.getString("salary")).append("\n\n");
                details.append("Address: ").append(rs.getString("address")).append("\n\n");
                details.append("Phone: ").append(rs.getString("phone")).append("\n\n");
                details.append("Email: ").append(rs.getString("email")).append("\n\n");
                details.append("Education: ").append(rs.getString("education")).append("\n\n");
                details.append("Designation: ").append(rs.getString("designation")).append("\n\n");
                details.append("Aadhar Number: ").append(rs.getString("aadhar")).append("\n\n");
                details.append("Employee ID: ").append(rs.getString("empID")).append("\n\n");
            }
            detailsArea.setText(details.toString());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new EmployeeDetailsFrame("empID"));
    }
}
