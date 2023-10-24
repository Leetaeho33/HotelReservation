import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Reservation {
    private Customer customer;
    private Room room;
    List<Date> reservationDate;
    Reservation reservation;

    public Reservation makeReservation(Customer customer, Room room, String Date){
        if(customer.getBudget() > room.getRoomPrice()){
            customer.setBudget();

            UUID uuid = UUID.randomUUID();
            customer.addUuid(uuid.toString());
        }
    }
}
// 예약 // 예약 취소 // 예약 확인 전체 예약확인
