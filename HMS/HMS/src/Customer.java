import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

class Customer extends Person
{
    private String city;
    private String contact;
    private String cnic;
    private int age;
    private String gender;
    Customer()
    {
        contact = "none";
        city = "none";
        age = 0;
        cnic = "none";
    }
    Customer(String name,String email, String contact,String city, int age,String cnic)
    {
        super(name,email);
        this.contact = contact;
        this.city = city;
        this.age = age;
        this.cnic = cnic;
    }
    public void setCity(String city)
    {
        this.city = city;
    }
    public void setContactNo(String contact)
    {
        this.contact = contact;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public String getCity()
    {
        return city;
    }
    public String getContactNo()
    {
        return contact;
    }
    public int getAge()
    {
        return age;
    }
    void storingdata() throws IOException {
        Scanner sc = new Scanner(System.in);
        String[] customerDetail = new String[6];
        customerDetail[0] = name;
        customerDetail[1] = Integer.toString(age);
        customerDetail[2] = contact;
        customerDetail[3] = city;
        customerDetail[4] = cnic;
        customerDetail[5] = email;
        System.out.println("Enter id = ");
        int id = sc.nextInt();
        //reading from file to check id is already present or not
        boolean checkingID = false;
        String array[] = new String[100];
        int j=0;
        while(!checkingID) {
            File myobj = new File("customer.txt");
            Scanner Reader = new Scanner(myobj);
            while (Reader.hasNextLine()) {
                String line = Reader.nextLine();
                array[j] = line;
                if(array[j].equals(Integer.toString(id))){
                    System.out.println("Id already present. Enter again.");
                    id = sc.nextInt();
                    continue;
                }
                j++;
            }
            Reader.close();
            checkingID = true;
        }
        //Writing on File
        FileWriter customerFile = new FileWriter("Customer.txt",true);
        PrintWriter fw = new PrintWriter(customerFile);
        fw.write(Integer.toString(id));
        fw.write("\n");
        for(int i=0;i< customerDetail.length;i++)
        {
            fw.write(customerDetail[i]+" ");
        }
        fw.write("\n");
        fw.close();
    }


    @Override
    void display()
    {
        super.display();
        System.out.println("Phone No = "+contact+"\ncnic = "+cnic+"\nAge = "+age+"\nCity  = "+city);
    }
}