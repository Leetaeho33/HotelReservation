import java.util.*;

public class Hotel {
    private int asset;
    private List<Room> roomList = new ArrayList<>();
    private Map<String, Reservation> reservationMap = new HashMap<>();

    public List<Room> getRoomList() {
        return roomList;
    }

    public void addRoom(Room room) {
        this.roomList.add(room);
    }

    public Room getRoom(int roomNumber){
        for (Room room : roomList) {
            if (room.getRoomNumber() == roomNumber) {
                return room;
            }
        }
        return null;

    }
    public void addReservation(Reservation reservation) {
        reservationMap.put(reservation.getReservationNumber(), reservation);
    }

    public void removeReservation(String reservationNumber) {
        this.reservationMap.remove(reservationNumber);
    }

    public void checkReservationCustomer(String reservationNumber) {
        for (String s : reservationMap.keySet()) {
            if (s.equals(reservationNumber)) {
                System.out.println("Name : " + reservationMap.get(s).getCustomer().getCustomerName() + " | " +
                        "Phone Number : " + reservationMap.get(s).getCustomer().getCustomerPhoneNumber() + " | " +
                        "Room Number : " + reservationMap.get(s).getRoom().getRoomNumber() + " | " +
                        "ReservationNumber : " + reservationNumber
                );
            }
        }
    }

    public void checkReservationHotel() {
        for (String s : reservationMap.keySet()) {
            System.out.println("Name : " + reservationMap.get(s).getCustomer().getCustomerName() + " | " +
                    "Phone Number : " + reservationMap.get(s).getCustomer().getCustomerPhoneNumber() + " | " +
                    "Room Number : " + reservationMap.get(s).getRoom().getRoomNumber() + " | " +
                    "ReservationNumber : " + reservationMap.get(s).getReservationNumber()
            );
        }
    }

}

