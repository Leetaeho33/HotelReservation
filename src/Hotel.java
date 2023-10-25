import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private int asset;
    List<Room> roomList = new ArrayList<>();
    Map<String, Reservation> reservationMap = new HashMap<>();

    public void addRoom(Room room){
        this.roomList.add(room);
    }

    public void checkReservationCustomer(String uuId){
        for(Map.Entry<String, Reservation> entry : reservationMap.entrySet()){
            if(entry.getKey().equals(uuId)){
                System.out.println("Name : " + entry.getValue().getCustomer().getCustomerName() + " | " +
                        "Phone Number : " + entry.getValue().getCustomer().getCustomerPhoneNumber() + " | " +
                        "Room Number : " + entry.getValue().getRoom().getRoomNumber() + " | " +
                        "Reservation Date : " + entry.getValue().reservationDate + " | " +
                        "UUID : " + entry.getKey());
            }
        }
    }

    public void checkReservationHotel(){
        for (Map.Entry<String, Reservation> entry : reservationMap.entrySet()) {
            System.out.println("Name : " + entry.getValue().getCustomer().getCustomerName() + " | " +
                    "Phone Number : " + entry.getValue().getCustomer().getCustomerPhoneNumber() + " | " +
                    "Room Number : " + entry.getValue().getRoom().getRoomNumber() + " | " +
                    "Reservation Date : " + entry.getValue().reservationDate + " | " +
                    "UUID : " + entry.getKey());
        }
    }


}

