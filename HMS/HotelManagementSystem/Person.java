import java.io.Serializable;

public class Person implements Serializable
{
    public String name;
    public int id;
    public String email;
    public String cnic;
    public int age;
    public String contact;
    Person()
    {
        name = "none";
        age = 0;
        id =0;
        contact="none";
        email="none";
        cnic="none";
    }
    Person(int id,String name,int age,String contact,String cnic,String email)
    {
        this.id = id;
        this.name = name;
        this.age = age;
        this.contact = contact;
        this.cnic = cnic;
        this.email = email;
    }
    public void setID(int id)
    {
        this.id = id;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    public void setAge(int age)
    {
        this.age = age;
    }
    public void setContact(String contact)
    {
        this.contact = contact;
    }
    public void setCNIC(String cnic)
    {
        this.cnic = cnic;
    }
    public void setEmail(String email)
    {
        this.email = email;
    }

    public int getId()
    {
        return id;
    }
    public String getName()
    {
        return name;
    }
    public int getAge()
    {
        return age;
    }
    public String getContact()
    {
        return contact;
    }
    public String getEmail()
    {
        return email;
    }
    public String getCNIC()
    {
        return cnic;
    }
}
