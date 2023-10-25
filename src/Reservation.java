import java.time.LocalDate;
import java.util.*;

public class Reservation {
    private Customer customer;
    private Room room;
    LocalDate reservationDate; // 이게 리스트가 아니어도 상관없지 않을까요...?
    //예약 객체는 고객, 방, 날짜 정보 포함

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }


}
// 예약 // 예약 취소 // 예약 확인 전체 예약확인
