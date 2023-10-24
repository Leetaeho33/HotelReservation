public class Room {

    private int roomNumber; // 각 방의 갯수는 3개
    private String roomSize; // 1층 Standard 2층 Twin 3층 Deluxe 4층 Suite
    private int roomPrice; // standard 5만원, Twin 10만원, Deluxe 15만원, Suite 40만원

    public int getRoomNumber() {
        return roomNumber;
    }
    public void setRoomNumber(int roomNumber) {
        this.roomNumber = roomNumber;
    }
    public String getRoomSize() {
        return roomSize;
    }
    public void setRoomSize(String roomSize) {
        this.roomSize = roomSize;
    }
    public int getRoomPrice() {
        return roomPrice;
    }
    public void setRoomPrice(int roomPrice) {
        this.roomPrice = roomPrice;
    }
    public Room(int roomNumber, String roomSize, int roomPrice) {
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomPirce = roomPirce;
    }

}
