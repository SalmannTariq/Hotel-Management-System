import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerAdminUI extends JFrame {

    private JLabel hotelNameLabel;
    private JButton customerButton;
    private JButton adminButton;

    public CustomerAdminUI() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Hotel Booking");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JPanel panel = new JPanel();
        panel.setLayout(new BorderLayout());
        
        hotelNameLabel = new JLabel("Welcome to Serena Hotel");
        hotelNameLabel.setFont(new Font("Arial", Font.BOLD, 24));
        hotelNameLabel.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(hotelNameLabel, BorderLayout.NORTH);

        JPanel buttonPanel = new JPanel(new FlowLayout());
        customerButton = new JButton("Customer");
        customerButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                CustomerUI();
            }
        });
        buttonPanel.add(customerButton);

        adminButton = new JButton("Admin");
        adminButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Perform admin-related actions
                AdminUI();
            }
        });
        buttonPanel.add(adminButton);

        panel.add(buttonPanel, BorderLayout.CENTER);
        getContentPane().add(panel);
    }

    private void CustomerUI() {
        Customer customerUI = new Customer();
        customerUI.setVisible(true);
        dispose();
        JLabel customerLabel = new JLabel("Customer UI");
        customerLabel.setFont(new Font("Arial", Font.BOLD, 24));
        customerLabel.setHorizontalAlignment(SwingConstants.CENTER);
        getContentPane().add(customerLabel, BorderLayout.CENTER);

        revalidate();
        repaint();
    }
    private void AdminUI()
    {
        Admin AdminUI = new Admin();
        AdminUI.setVisible(true);
        dispose();
        revalidate();
        repaint();
    }
}
