import java.util.Scanner;

import javax.swing.SwingUtilities;

public class mainMethod
{
    public static void main(String[] args)
    {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new CustomerAdminUI().setVisible(true);
            }
        });
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a value: ");
        String input = scanner.nextLine();
        System.out.println("You entered: " + input);
        
        // Additional console logic can be added here
        // Close the scanner
        scanner.close();
    }
}