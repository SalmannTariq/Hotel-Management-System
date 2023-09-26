import javax.swing.*;
import java.util.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Admin extends JFrame {

    private JButton searchButton;
    private JButton deleteButton;
    private JButton viewButton;

    private JTextField passwordField;
    private JButton loginButton;

    private JPanel loginPanel;
    private JPanel adminPanel;

    public Admin() {
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Admin Interface");
        setSize(300, 200);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        loginPanel = new JPanel();
        loginPanel.setLayout(new FlowLayout());

        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JTextField(15);
        loginButton = new JButton("Login");

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String password = passwordField.getText();
                if (authenticate(password)) {
                    showAdminPanel();
                } else {
                    JOptionPane.showMessageDialog(Admin.this,
                            "Incorrect password. Try again.",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        loginPanel.add(passwordLabel);
        loginPanel.add(passwordField);
        loginPanel.add(loginButton);

        adminPanel = new JPanel();
        adminPanel.setLayout(new GridLayout(3, 1));

        searchButton = new JButton("Search Customer Record");
        deleteButton = new JButton("Delete Customer Record");
        viewButton = new JButton("View Customers Record");

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your code for searching customer record here
                try{
                    SearchCustomer();
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Add your code for deleting customer record here
                try{
                    DeleteCustomer();
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
                
            }
        });

        viewButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    ViewCustomerRecords();
                }catch(Exception ex)
                {
                    ex.printStackTrace();
                }
            }
        });

        adminPanel.add(searchButton);
        adminPanel.add(deleteButton);
        adminPanel.add(viewButton);

        getContentPane().add(loginPanel);
    }

    private boolean authenticate(String password) {

        String correctPassword = "admin123";
        return password.equals(correctPassword);
    }
    public void SearchCustomer() throws IOException
    {
        int i=0;
        String[] array = new String[100];
        Scanner sc = new Scanner(System.in);
        File myobj = new File("Customer.txt");
        Scanner Reader = new Scanner(myobj);
        while (Reader.hasNextLine()) {
            String line = Reader.nextLine();
            array[i] = line;
            i++;
        }
        Reader.close();
        System.out.println("Enter id: ");
        //searching by ID
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input. Enter again: ");
            sc.next();
        }
        int id = sc.nextInt();
        boolean found = false;
        String enterID = Integer.toString(id);
        for(int k=0;k<i;k++){
            if(array[k].equals(enterID)){
                System.out.println(array[k+1]);
                found = true;
                break;
            }
        }
        //searching in file
        if(!found){
            System.out.println("No data found on this id.");
        }
    }
    public void DeleteCustomer() throws IOException
    {
        String[] array = new String[100];
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter id : ");
        //taking id to delete record
        while(!sc.hasNextInt()){
            System.out.println("Invalid Input.Enter again.");
            sc.next();
        }

        int id = sc.nextInt();
        String id2 = Integer.toString(id);
        int i=0;
        File myobj = new File("customer.txt");
        Scanner Reader = new Scanner(myobj);
        while(Reader.hasNextLine()){
            String line = Reader.nextLine();
            array[i] = line;
            i++;
        }
        //reading file
        Reader.close();
        boolean found = false;
        FileWriter fw = new FileWriter("customer.txt");
        for(int j=0;j<i;j++){
            if(array[j].equals(id2)){
                fw.write(" ");
                System.out.println("Record has been deleted");
                found = true;
                array[j+1] = " ";
            }
            else {
                fw.write(array[j]+"\n");
            }
        }
        //writing records back to file
        fw.close();
        if(!found){
            System.out.println("id not Found.");
            DeleteCustomer();
        }
    }
    public void ViewCustomerRecords() throws FileNotFoundException
    {
        String[] array = new String[100];
        int i=0;
        File myFile = new File("Customer.txt");
        Scanner sn = new Scanner(myFile);
        while(sn.hasNextLine())
        {
            String line = sn.nextLine();
            array[i] = line;
            i++;
        }
        sn.close();
        
        for(int j=0;j<i-1;j++)
        {
            System.out.println(array[j]);
        }
    }
    private void showAdminPanel() {
        getContentPane().remove(loginPanel);
        getContentPane().add(adminPanel);
        revalidate();
        repaint();
    }
}
