import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reservation {
    private Room hotelRoom;
    private Customer customer;
    private String reservationDate;
    private String uuid;
    private Map<String, Reservation> reservationMap = new HashMap<>(); // 예약uuid당 예약 하나
    private ArrayList<Room> reservationableHotelRoom = new ArrayList<>(); // 해당날짜에 예약 가능한 방들
    private Reservation reservationInstance = new Reservation(); // 예약 객체 안엔 객실/고객/예약날짜/uuid정보

    private String reservation(Customer customer, Room hotelRoom, String reservationDate){
        //고객, 객실, 예약 날짜를 받아 예약
        return uuid;
    }
    private Reservation checkReservation(String uuid){
        // uuid로 찾아서 예약객체 반환
        return reservationInstance;
    }
    private Map<String, Reservation> checkAllReservation(){
        //전체 예약 조회
        return reservationMap;
    }
    private void cancelReservation(String uuid){
        //예약 취소
    }
}
