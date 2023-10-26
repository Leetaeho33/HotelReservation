import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;

public class Hotel {
    private int asset = 0;
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
        this.reservationMap.put(reservation.getReservationNumber(), reservation);
        this.reservationCount += 1;
        this.addAsset();
    }

    public void removeReservation(String reservationNumber) {
        this.reservationMap.remove(reservationNumber);
    }

    public Reservation checkReservationCustomer(String reservationNumber) {
        if (this.reservationMap.containsKey(reservationNumber)) {
            for (String s : reservationMap.keySet()) {
                if (s.equals(reservationNumber)) {
//                    System.out.println("Name : " + reservationMap.get(s).getCustomer().getCustomerName() + " | " +
//                            "Phone Number : " + reservationMap.get(s).getCustomer().getCustomerPhoneNumber() + " | " +
//                            "Room Number : " + reservationMap.get(s).getRoom().getRoomNumber() + " | " +
//                            "ReservationNumber : " + reservationNumber
//                    );
                    return reservationMap.get(s);
                }
            }
        } return null;
    }

    public void checkReservationHotel() {
        if (this.reservationMap.isEmpty()) {
            System.out.println("예약된 내역이 없습니다.");
        } else {
            for (String s : reservationMap.keySet()) {
                System.out.println(
                        "예약날짜 : " + reservationMap.get(s).getReservationDate() + " | " +
                        "예약자 성명 : " + reservationMap.get(s).getCustomer().getCustomerName() + " | " +
                        "전화번호 : " + reservationMap.get(s).getCustomer().getCustomerPhoneNumber() + " | " +
                        "객실호수 : " + reservationMap.get(s).getRoom().getRoomNumber() + " | " +
                        "예약번호 : " + reservationMap.get(s).getReservationNumber()
                );
            }
        }
    }

    public List<Room> getPossibleRoomList(Date date){

        Instant instant = date.toInstant();
        // Instant를 ZoneId와 LocalDate로 변환
        ZoneId zoneId = ZoneId.systemDefault(); // 또는 다른 시간대를 사용할 수 있습니다.
        LocalDate localDate = instant.atZone(zoneId).toLocalDate();


        List<Room> possibleRoomList = new ArrayList<>();
        for (Room r : this.roomList) {
            if(r.getRoomDateList().isEmpty()){
                possibleRoomList.add(r);
            } else {
                for (Date d : r.getRoomDateList()) {

                    Instant instant1 = d.toInstant();
                    // Instant를 ZoneId와 LocalDate로 변환
                    ZoneId zoneId1 = ZoneId.systemDefault(); // 또는 다른 시간대를 사용할 수 있습니다.
                    LocalDate locald = instant.atZone(zoneId1).toLocalDate();


                    if(locald.compareTo(localDate) != 0){
                        possibleRoomList.add(r);
                    }
                }
            }
        }
        return possibleRoomList;
    }

    public int getAsset() {
        return asset;
    }

    public void addAsset() {
        for (String s : reservationMap.keySet()) {
            this.asset += reservationMap.get(s).getRoom().getRoomPrice();
        }
    }

    public int getReservationCount() {
        return reservationCount;
    }
}

