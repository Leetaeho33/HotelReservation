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
        this.addAsset(reservation.getReservationNumber());                         //예약 맵에 추가시 호텔 자산 증가
    }

    public void removeReservation(String reservationNumber) {
        this.asset -= reservationMap.get(reservationNumber).getRoom().getRoomPrice(); // 예약취소 시 호텔 자산 감소// 호텔 에약 수 감소
        Date date;
        date = this.reservationMap.get(reservationNumber).getReservationDate();
        this.reservationMap.get(reservationNumber).getRoom().removeRoomDate(date);    // 예약 취소 방 date
        this.reservationMap.remove(reservationNumber);                                // 호텔 예약 리스트 삭제
        this.reservationCount--;

    }

    public Reservation checkReservationCustomer(String reservationNumber) {
        if (this.reservationMap.containsKey(reservationNumber)) {
            for (String s : reservationMap.keySet()) {
                if (s.equals(reservationNumber)) {
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

        //LocalDate localDate = dateToLocalDate(date); //Date타입을 LocalDate타입으로 변환해주는 함수
        List<Room> possibleRoomList = new ArrayList<>();
        for (Room r : this.roomList) {
            if(r.getRoomDateList().isEmpty()){
                possibleRoomList.add(r);
            } else {
                if(!r.getRoomDateList().contains(date)){
                    possibleRoomList.add(r);
                }
            }
        }
        return possibleRoomList;
    }

    public int getAsset() {
        return asset;
    }

    public void addAsset(String uuid) {
        this.asset += reservationMap.get(uuid).getRoom().getRoomPrice();    //uuid값을 받아서 해당 예약의 방가격 만큼 호텔 자산 증가
    }

    public int getReservationCount() {
        return reservationCount;
    }


}

