import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class Admin extends Person
{
    private String password;
    Admin()
    {
        password = "none";
    }
    Admin(String name,String email,String password)
    {
        super(name,email);
        this.password = password;
    }
    public void setPassword(String password)
    {
        this.password = password;
    }
    public String getPassword()
    {
        return password;
    }
    void searchCustomerRecord() throws FileNotFoundException {
        System.out.println("---------------------------");
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
        //in case of invalid
        System.out.println("---------------------------");
    }
    void deleteCustomerRecord() throws IOException {
        String[] array = new String[100];
        System.out.println("---------------------------");
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
        File myobj = new File("Customer.txt");
        Scanner Reader = new Scanner(myobj);
        while(Reader.hasNextLine()){
            String line = Reader.nextLine();
            array[i] = line;
            i++;
        }
        //reading file
        Reader.close();
        boolean found = false;
        FileWriter fw = new FileWriter("Customer.txt");
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
            deleteCustomerRecord();
        }
        //in case of no id found
        System.out.println("---------------------------");
    }
    void viewCustomerRecord() throws FileNotFoundException {
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
    void check() throws FileNotFoundException {
        if(password.equals("Admin@123"))
        {
            System.out.println("1. Search Customer Record");
            System.out.println("2. Delete Customer Record");
            System.out.println("3. View Customer Record");
            System.out.println("4. Update Room Record");
            System.out.println("5. Update Dining Record");
            System.out.println("6. Delete Dining Record");

            System.out.print("Select a number = ");
            Scanner in = new Scanner(System.in);
            int num = in.nextInt();
            if(num==1)
            {
                try {
                    searchCustomerRecord();
                }catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            else if(num==2)
            {
                try {
                    deleteCustomerRecord();
                }catch (Exception e)
                {
                    System.out.println(e);
                }
            }
            else if(num==3)
            {
                try
                {
                    viewCustomerRecord();
                }catch(Exception e)
                {
                    System.out.println(e);
                }
            }
        }
        else
        {
            System.out.println("The password you have entered is incorrect.");
        }
    }
    @Override
    void display()
    {
        super.display();
        System.out.println("Password = "+password);
    }
}