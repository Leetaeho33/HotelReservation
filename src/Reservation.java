import java.util.*;

public class Reservation {
    private Customer customer;
    private Room room;
    List<Date> reservationDate;
    Reservation reservation;

    public Reservation makeReservation(Customer customer, Room room, Date date){
        this.customer = customer;                                          //예약 객체의 고객 정보 저장
        this.room = room;                                                  //예약 객체의 방 정보 저장
        if(this.customer.getBudget() > this.room.getRoomPrice()){          //손님의 예산 > 방가격
//          customer.setBudget(customer.getBudget()- room.getRoomPrice()); //예약 성공 시 손님 소지금 삭감
            UUID uuid = UUID.randomUUID();                                 //고객에게 제공할 UUID 생성
            customer.addUuid(uuid.toString());                             //예약 성공 시 고객에게 UUID 제공
            reservationDate.add(date);
        }
        return reservation;                                                //예약 성공 시 예약 객체 반환
    }                                                                      //예약 객체는 고객, 방, 날짜 정보 포함

}
// 예약 // 예약 취소 // 예약 확인 전체 예약확인
