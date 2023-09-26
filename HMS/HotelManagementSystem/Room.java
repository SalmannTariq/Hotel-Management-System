public class Room {
    
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
    void bookedNormalRooms() 
    {
        
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
