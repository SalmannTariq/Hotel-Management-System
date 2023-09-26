import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
//import java.io.Serializable;
public class Customer extends JFrame {

    JTextField nameTextField;
     JTextField ageTextField;
     JTextField emailTextField;
     JTextField contactTextField;
     JTextField cnicTextField;
     JTextField idTextField;

    private JLabel nameLabel;
    private JLabel ageLabel;
    private JLabel emailLabel;
    private JLabel contactLabel;
    private JLabel cnicLabel;
    private JLabel idLabel;

    private JButton submitButton;

    public Customer() {
        CustomerUI();
    }

    private void CustomerUI() {
        setTitle("Customer Registration");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel();
        panel.setLayout(new GridLayout(7, 2));

        nameLabel = new JLabel("Name:");
        nameTextField = new JTextField();
        panel.add(nameLabel);
        panel.add(nameTextField);

        ageLabel = new JLabel("Age:");
        ageTextField = new JTextField();
        panel.add(ageLabel);
        panel.add(ageTextField);

        idLabel = new JLabel("ID:");
        idTextField = new JTextField();
        panel.add(idLabel);
        panel.add(idTextField);

        emailLabel = new JLabel("Email:");
        emailTextField = new JTextField();
        panel.add(emailLabel);
        panel.add(emailTextField);

        contactLabel = new JLabel("Contact:");
        contactTextField = new JTextField();
        panel.add(contactLabel);
        panel.add(contactTextField);

        cnicLabel = new JLabel("CNIC:");
        cnicTextField = new JTextField();
        panel.add(cnicLabel);
        panel.add(cnicTextField);

        submitButton = new JButton("Submit");
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (validateFields()) {
                    String name = nameTextField.getText();
                    int age = Integer.parseInt(ageTextField.getText());
                    String email = emailTextField.getText();
                    String contact = contactTextField.getText();
                    String cnic = cnicTextField.getText();
                    int id = Integer.parseInt(idTextField.getText());
                    //Person p = new Person(id,name,age,contact,cnic,email);
                    String id2 = Integer.toString(id);
                    try
                    {
                        FileWriter fw = new FileWriter("customer.txt",true);
                        fw.write(id2);
                        fw.write("\n");
                        fw.write(name+" "+age+" "+contact+" "+cnic+" "+email);
                        fw.write("\n");
                        fw.close();
                        JOptionPane.showMessageDialog(Customer.this,
                            "Customer registration successful!",
                            "Success",
                            JOptionPane.INFORMATION_MESSAGE);
                            dispose();
                    }catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }

                    try{
                        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("customer.txt"));
                        Person p1 = (Person)ois.readObject();
                        System.out.println("ID = "+p1.id+"\nName = "+p1.name+"\nAge = "+p1.age+"\nContact = "+p1.contact+
                        "\nCNIC = "+p1.cnic+"\nEmail = "+p1.email);
                        ois.close();
                    }catch(Exception ex)
                    {
                        ex.printStackTrace();
                    }
                }
            }
        });
        panel.add(submitButton);
        getContentPane().add(panel);
        dispose();
    }

    private boolean validateFields() {
        String name = nameTextField.getText();
        String ageText = ageTextField.getText();
        String email = emailTextField.getText();
        String contact = contactTextField.getText();
        String cnic = cnicTextField.getText();
        String id = idTextField.getText();

        if (name.isEmpty() || ageText.isEmpty() || email.isEmpty() || contact.isEmpty() || cnic.isEmpty() || id.isEmpty()) {
            JOptionPane.showMessageDialog(this,
                    "All fields are required!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate name (only alphabets and spaces allowed)
        for (int i = 0; i < name.length(); i++) {
            try {
                if ((name.charAt(i) >= 65 && name.charAt(i) <= 90) || (name.charAt(i) >= 97 && name.charAt(i) <= 122) || name.charAt(i)== ' ') {
                    continue;
                } else {
                    JOptionPane.showMessageDialog(this,
                    "Invalid name! Only alphabets and spaces are allowed.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
                    return false;
                }
            } catch (Exception e) {
                System.out.print(e);
            }
        }

        // Validate age (must be a positive integer)
        try {
            int age = Integer.parseInt(ageText);
            if (age <= 0) {
                JOptionPane.showMessageDialog(this,
                        "Invalid age! Age must be a positive integer.",
                        "Error",
                        JOptionPane.ERROR_MESSAGE);
                return false;
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this,
                    "Invalid age! Age must be a positive integer.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
        // checking id
        boolean check = false;
        try{
            for(int i=0;i<id.length();i++)
            {
                if(id.charAt(i) >= 48 && id.charAt(i) <= 57)
                {
                    check = true;
                }
                else{
                    check = false;
                    break;
                }
            }
            if(!check)
            {
                JOptionPane.showMessageDialog(this,
                    "Invalid id!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            }
        }catch(Exception ex)
        {
            ex.printStackTrace();
        }
        // Validate email using a simple regex pattern
        String emailRegex = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
        Pattern emailPattern = Pattern.compile(emailRegex);
        Matcher emailMatcher = emailPattern.matcher(email);
        if (!emailMatcher.matches()) {
            JOptionPane.showMessageDialog(this,
                    "Invalid email address!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }

        // Validate contact number (must be a 10-digit number)
        boolean contactNo = false;
                while (!contactNo) {
                    int len = contact.length();
                    if (len == 11) {
                        for (int i = 0; i < contact.length(); i++) {
                            if ((contact.charAt(i) >= 48 && contact.charAt(i) <= 57))
                                continue;
                            else {
                                JOptionPane.showMessageDialog(this,
                        "Invalid contact number!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                            return false;
                            }
                        }
                        contactNo = true;
                    } else {
                            JOptionPane.showMessageDialog(this,
                            "Contact number must be of 11-digits!",
                            "Error",
                            JOptionPane.ERROR_MESSAGE);
                            return false;
                    }
                }

        // Validate CNIC (must be a 13-digit number)
        if (!cnic.matches("^[0-9]{13}$")) {
            JOptionPane.showMessageDialog(this,
                    "Invalid CNIC! CNIC must be a 13-digit number.",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
            return false;
        }
    
        return true;
    }
}
