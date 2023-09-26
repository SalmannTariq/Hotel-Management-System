import java.io.*;
import java.util.*;
import java.util.ArrayList;
class Person
{
    protected String name;
    protected String email;
    Person()
    {
        name = "none";
        email = "none";
    }
    Person(String name, String email)
    {
        this.name = name;
        this.email = email;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }
    public String getName()
    {
        return name;
    }
    public String getEmail()
    {
        return email;
    }
    void display()
    {
        System.out.println("Name = "+name +"\nEmail =  "+ email);
    }
}

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
class Room {
    private int roomNumber;
    private String roomType;
    private boolean isBooked;
    private int floor;
    Room()
    {
        roomNumber = 0;
        roomType = "none";
        isBooked = false;
        floor = 0;
    }
    Room(int roomNumber, String roomType, int floor)
    {
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.floor = floor;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getRoomType() {
        return roomType;
    }

    public void setRoomType(String roomType) {
        this.roomType = roomType;
    }

    boolean isBooked(boolean flag)
    {
        if(flag)
        {
            System.out.println("Your Room Booking Details:");
            System.out.println("Room No = "+roomNumber+"\nRoom Type = "+roomType+"\nFloor = "+floor);
            return true;
        }
        else
        {
            return false;
        }
    }
    void typeOfRooms()
    {
        System.out.println("1 Normal Room - Charges per Hour = 200 - Rooms = 1-15 - Floor = 1st" +
                "\n2 Elite Room - Chargers per Hour = 500 - Rooms = 100-115 - Floor = 2nd" +
                "\n3 Luxury Room - Charges per Hours = 800 - Rooms = 200-215 - Floor = 3rd");
    }
    void normalRoom()
    {

        System.out.println("Room Specs:\nDouble Bed\nWashroom\nLED");
    }
    void bookedNormalRooms() throws IOException {
        Scanner rIN = new Scanner(System.in);
        System.out.println("Enter your room number:");
        int rNo = rIN.nextInt();
        ArrayList<Integer> arr = new ArrayList<>(null);
        boolean checkingID = false;
        //reading from file
        File myobj = new File("normalRoom.txt");
        Scanner Reader = new Scanner(myobj);
        while (Reader.hasNextInt()) {
            int line = Reader.nextInt();
            arr.add(line);
        }
        Reader.close();
        System.out.println("printing data of array");
        for(int i =0; i<arr.size();i++)
        {
            System.out.println(arr.get(i));
        }
        //Writing on File
        // FileWriter customerFile = new FileWriter("normalRoom.txt",true);
        // PrintWriter fw = new PrintWriter(customerFile);
        // fw.write(rNo);
        // fw.write("\n");
        // for(int i=0;i<array.length;i++)
        // {
        //     fw.write(array[i]);
        //     fw.write("\n");
        // }
        // fw.write("\n");
        // fw.close();
    }
    void eliteRoom()
    {
        System.out.println("Room Specs:\nDouble Bed\nWashroom\nLED\nFridge\nCupBoard");
    }
    void luxuryRoom()
    {
        System.out.println("Room Specs:\nDouble Bed\nWashroom\nLED\nFridge\nCupBoard\nAC");
    }
}
public class HMS {
    public static void main(String[] args) throws IOException {
        System.out.println("---------------------------");
        System.out.println("| Welcome to 7 Star Hotel |");
        System.out.println("---------------------------");
        Scanner sc = new Scanner(System.in);
        System.out.println("1 Customer\n2 Admin");
        int n = sc.nextInt();
        if (n == 1)
        {
            System.out.print("Enter your First Name = ");
            sc.nextLine();
            String firstName = sc.nextLine();
            int lenName = firstName.length();
            for (int i = 0; i < lenName; i++) {
                try {
                    if ((firstName.charAt(i) >= 65 && firstName.charAt(i) <= 90) || (firstName.charAt(i) >= 97 && firstName.charAt(i) <= 122)) {
                        continue;
                    } else {
                        System.out.print("Invalid Input. Enter your First name in Alphabets : ");
                        firstName = sc.nextLine();
                        lenName = firstName.length();
                        i = 0;
                    }
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
            //checking last name
            System.out.print("Enter your Last Name = ");
            String lastName = sc.nextLine();
            int lenName2 = lastName.length();
            for (int i = 0; i < lenName2; i++) {
                try {
                    if ((lastName.charAt(i) >= 65 && lastName.charAt(i) <= 90) || (lastName.charAt(i) >= 97 && lastName.charAt(i) <= 122)) {
                        continue;
                    } else {
                        System.out.print("Invalid Input. Enter your Last name in Alphabets : ");
                        lastName = sc.nextLine();
                        lenName2 = lastName.length();
                        i = 0;
                    }
                } catch (Exception e) {
                    System.out.print(e);
                }
                i = 0;
            }
            String name = firstName + " "+lastName;
            // Age
            System.out.print("Enter your age = ");
            while (!sc.hasNextInt()) {
                System.out.println("Invalid Input. Enter again:");
                sc.next();
            }
            int age = sc.nextInt();
            if (age <= 18) {
                System.out.println("You are invalid for our hotel.");
            } else {
                boolean contactNo = false;
                Scanner obj = new Scanner(System.in);
                // contact number
                System.out.print("Enter you Contact number : ");
                String contact = obj.nextLine();
                while (!contactNo) {
                    int len = contact.length();
                    if (len == 11) {
                        for (int i = 0; i < contact.length(); i++) {
                            if ((contact.charAt(i) >= 48 && contact.charAt(i) <= 57))
                                continue;
                            else {
                                System.out.print("Invalid Input. Enter your contact number again : ");
                                contact = obj.nextLine();
                                i = 0;
                            }
                        }
                        contactNo = true;
                    } else {
                        System.out.println("Invalid Input. Enter contact number again:");
                        contact = obj.nextLine();
                    }
                }
                // City
                System.out.print("Enter your city = ");
                String city = obj.nextLine();
                int lenCity = city.length();
                for (int i = 0; i < lenCity; i++) {
                    if ((city.charAt(i) >= 65 && city.charAt(i) <= 90) || (city.charAt(i) >= 97 && city.charAt(i) <= 122))
                        continue;
                    else {
                        System.out.print("Invalid Input. Enter your city name again : ");
                        city = obj.nextLine();
                        lenCity = city.length();
                        i = 0;
                    }
                }
                // Cnic
                System.out.print("Enter your cnic in this form xxxxx-xxxxxxx-x : ");
                String cnic = obj.nextLine();
                boolean cnicc = false;
                while (!cnicc) {
                    int lenCnic = cnic.length();
                    if (lenCnic == 15) {
                        for (int i = 0; i < lenCnic; i++) {
                            if ((cnic.charAt(i) >= 48 && cnic.charAt(i) <= 57) || (cnic.charAt(i) == '-')) {
                                if (i == 5 || i == 13) {
                                    if (cnic.charAt(i) == '-') {
                                        continue;
                                    } else {
                                        System.out.print("Invalid cnic. Enter your cnic in this form xxxxx-xxxxxxx-x : ");
                                        cnic = obj.nextLine();
                                        i = 0;
                                    }
                                }
                            } else {
                                System.out.print("Invalid cnic . Enter your cnic in this form xxxxx-xxxxxxx-x : ");
                                cnic = obj.nextLine();
                            }
                        }
                        cnicc = true;
                    } else {
                        System.out.println("3-Invalid cnic.\nEnter your cnic in this form xxxxx-xxxxxxx-x: ");
                        cnic = obj.nextLine();
                    }
                }
                System.out.print("Email = ");
                sc.nextLine();
                String email = sc.nextLine();
                Person p = new Person(name, email);
                Customer c = new Customer(name, email, contact, city, age, cnic);
                try
                {
                    c.storingdata();
                }catch(Exception e)
                {
                    System.out.println(e);
                }


                System.out.println("1. Book Rooms");
                System.out.println("2. Order Food");
                System.out.print("Enter your choice = ");
                int choice = sc.nextInt();


                if(choice == 1)
                {
                    Room room = new Room();
                    System.out.println("Select room type from these 3 categories :");
                    room.typeOfRooms();
                    int roomCat = sc.nextInt();
                    if(roomCat==1)
                    {
                        room.normalRoom();
                        System.out.println("Confirm your booking? 1 for Yes 0 for No : ");
                        int confirm = sc.nextInt();
                        if(confirm==1)
                        {
                            try
                            {
                                room.bookedNormalRooms();
                            }catch(Exception e)
                            {
                                System.out.println(e);
                            }
                            
                        }
                        else
                        {
                            System.out.println("Your booking is cancel");
                        }

                    }
                }
                else if(choice == 2) {}
            }//else age
        }
        else if(n==2)
        {
            System.out.print("Enter your First Name = ");
            sc.nextLine();
            String firstName = sc.nextLine();
            int lenName = firstName.length();
            for (int i = 0; i < lenName; i++) {
                try {
                    if ((firstName.charAt(i) >= 65 && firstName.charAt(i) <= 90) || (firstName.charAt(i) >= 97 && firstName.charAt(i) <= 122)) {
                        continue;
                    } else {
                        System.out.print("Invalid Input. Enter your First name in Alphabets : ");
                        firstName = sc.nextLine();
                        lenName = firstName.length();
                        i = 0;
                    }
                } catch (Exception e) {
                    System.out.print(e);
                }
            }
            //checking last name
            System.out.print("Enter your Last Name = ");
            String lastName = sc.nextLine();
            int lenName2 = lastName.length();
            for (int i = 0; i < lenName2; i++) {
                try {
                    if ((lastName.charAt(i) >= 65 && lastName.charAt(i) <= 90) || (lastName.charAt(i) >= 97 && lastName.charAt(i) <= 122)) {
                        continue;
                    } else {
                        System.out.print("Invalid Input. Enter your Last name in Alphabets : ");
                        lastName = sc.nextLine();
                        lenName2 = lastName.length();
                        i = 0;
                    }
                } catch (Exception e) {
                    System.out.print(e);
                }
                i = 0;
            }
            String name = firstName + " "+lastName;
            System.out.print("Email = ");
            String email = sc.nextLine();
            System.out.print("Enter Password = ");
            String pas = sc.nextLine();
            for(int i=0;i<pas.length();i++)
            {
                if((pas.charAt(i) >= 65 && pas.charAt(i) <= 90)||(pas.charAt(i) >= 97 && pas.charAt(i) <= 122)|| pas.charAt(i)==64
                || (pas.charAt(i) >= 48 && pas.charAt(i) <= 57))
                {
                    continue;
                }
                else
                {
                    System.out.println("Invalid Password. Enter Again.");
                    pas = sc.nextLine();
                    i=0;
                }
            }
            Admin ad = new Admin(name,email,pas);
            try{
                ad.check();
            }catch (Exception e)
            {
                System.out.println(e);
            }

        }
    }
}