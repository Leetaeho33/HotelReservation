import java.util.*;

public class Hotel {
    private int asset;
    List<Room> roomList = new ArrayList<>();
    Map<String, Reservation> reservationMap = new HashMap<>();

    public void addRoom(Room room){
        this.roomList.add(room);
    }

    public void checkReservationCustomer(String reservationNumber){
        for (String s : reservationMap.keySet()) {
            if(s.equals(reservationNumber)){
                System.out.println("Name : " + reservationMap.get(s).getCustomer().getCustomerName() + " | " +
                        "Phone Number : " + reservationMap.get(s).getCustomer().getCustomerPhoneNumber() + " | " +
                        "Room Number : " + reservationMap.get(s).getRoom().getRoomNumber() + " | " +
                        "ReservationNumber : " + reservationNumber
                );
            }
        }
    }

    public void checkReservationHotel(){
        for (String s : reservationMap.keySet()) {
            System.out.println("Name : " + reservationMap.get(s).getCustomer().getCustomerName() + " | " +
                    "Phone Number : " + reservationMap.get(s).getCustomer().getCustomerPhoneNumber() + " | " +
                    "Room Number : " + reservationMap.get(s).getRoom().getRoomNumber() + " | " +
                    "ReservationNumber : " + reservationMap.get(s).getReservationNumber()
            );
        }
    }


}

