import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class food {
    private int foodID;
    private String name;
    private double price;
    private boolean isAvailable;

    public food(int foodID, String name, double price, boolean isAvailable) {
        this.foodID = foodID;
        this.name = name;
        this.price = price;
        this.isAvailable = isAvailable;
    }

    public int getFoodID() {
        return foodID;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public void displayFoodDetails() {
        JFrame frame = new JFrame("Food Details");
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setLayout(new BorderLayout());

        JPanel panel = new JPanel(new GridLayout(3, 2));

        JLabel nameLabel = new JLabel("Name:");
        JLabel priceLabel = new JLabel("Price:");
        JLabel availabilityLabel = new JLabel("Availability:");

        JLabel nameValueLabel = new JLabel(name);
        JLabel priceValueLabel = new JLabel(Double.toString(price));
        JLabel availabilityValueLabel = new JLabel(isAvailable ? "Available" : "Not Available");

        panel.add(nameLabel);
        panel.add(nameValueLabel);
        panel.add(priceLabel);
        panel.add(priceValueLabel);
        panel.add(availabilityLabel);
        panel.add(availabilityValueLabel);

        JButton closeButton = new JButton("Close");
        closeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.dispose();
            }
        });

        frame.add(panel, BorderLayout.CENTER);
        frame.add(closeButton, BorderLayout.SOUTH);

        frame.setVisible(true);
    }
}
