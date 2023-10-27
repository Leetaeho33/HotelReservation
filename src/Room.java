import java.util.ArrayList;
import java.util.Date;

public class Room {

    private int roomNumber; // 각 방의 갯수는 3개
    private String roomSize; // 1층 Standard 2층 Twin 3층 Deluxe 4층 Suite
    private int roomPrice; // standard 5만원, Twin 10만원, Deluxe 15만원, Suite 40만원
    private ArrayList<Date> roomDateList = new ArrayList<>(); // 방의 날짜별 예약을 위한 날짜 list

    public Room(int roomNumber, String roomSize, int roomPrice) {
        this.roomNumber = roomNumber;
        this.roomSize = roomSize;
        this.roomPrice = roomPrice;
    }
    public int getRoomNumber() {
        return roomNumber;
    }
    public String getRoomSize() {
        return roomSize;
    }
    public int getRoomPrice() {
        return roomPrice;
    }

    public ArrayList<Date> getRoomDateList() {
        return roomDateList;
    }
    public boolean checkRoomReservation(Date date){         //룸 예약 가능 확인 메소드
        if(this.roomDateList.contains(date)){                    //룸의 date list에 매개변수 date값이있냐?
            return false;                                   //있으면 예약 불가능!
        }else {
            return true;                                    //없으면 예약 가능
        }
    }
    public void addRoomDate(Date date){
        this.roomDateList.add(date);
    }
}
