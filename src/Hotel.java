import java.util.*;

public class Hotel {
    private int asset;
    private int reservationCount = 0;
    private List<Room> roomList = new ArrayList<>();
    private Map<String, Reservation> reservationMap = new HashMap<>();

    public List<Room> getRoomList() {
        return roomList;
    }

    public void addRoom(Room room) {
        this.roomList.add(room);
    }

    public Room getRoom(int roomNumber) {
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
        if (reservationMap.containsKey(reservationNumber)) {
            for (String s : reservationMap.keySet()) {
                if (s.equals(reservationNumber)) {
                    System.out.println("Name : " + reservationMap.get(s).getCustomer().getCustomerName() + " | " +
                            "Phone Number : " + reservationMap.get(s).getCustomer().getCustomerPhoneNumber() + " | " +
                            "Room Number : " + reservationMap.get(s).getRoom().getRoomNumber() + " | " +
                            "ReservationNumber : " + reservationNumber
                    );
                }
            }
        } else {
            System.out.println("예약번호에 해당하는 예약이 존재하지 않습니다.");
        }
    }

    public void checkReservationHotel() {
        if (this.reservationMap.isEmpty()) {
            System.out.println("예약된 내역이 없습니다.");
        } else {
            for (String s : reservationMap.keySet()) {
                System.out.println("Name : " + reservationMap.get(s).getCustomer().getCustomerName() + " | " +
                        "Phone Number : " + reservationMap.get(s).getCustomer().getCustomerPhoneNumber() + " | " +
                        "Room Number : " + reservationMap.get(s).getRoom().getRoomNumber() + " | " +
                        "ReservationNumber : " + reservationMap.get(s).getReservationNumber()
                );
            }
        }
    }

    public int getAsset() {
        return asset;
    }

    public void addAsset() {
        for (String s : reservationMap.keySet()) {
            this.asset += reservationMap.get(s).getRoom().getRoomPrice();
            this.reservationCount++;
        }
    }
}

