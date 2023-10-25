import java.time.LocalDate;
import java.util.*;

public class Reservation {
    private Customer customer;
    private Room room;
    LocalDate reservationDate; // 이게 리스트가 아니어도 상관없지 않을까요...?

    public Reservation makeReservation(Customer customer, Room room, String date){ //
        this.customer = customer;                                          //예약 객체의 고객 정보 저장
        this.room = room;                                                  //예약 객체의 방 정보 저장
        if(this.customer.getBudget() > this.room.getRoomPrice()){          //손님의 예산 > 방가격
//          customer.setBudget(customer.getBudget()- room.getRoomPrice()); //예약 성공 시 손님 소지금 삭감  // 황규정 : view에서 보니 준영님과 유섭님이 Customer를
//                                                                              반복해서 받는작업이 있어서.. 회원가입을 만들지 않는다면 소지금을 빼줄 필요가 없을것같습니다..!
            UUID uuid = UUID.randomUUID();                                 //고객에게 제공할 UUID 생성
            customer.addUuid(uuid.toString());                             //예약 성공 시 고객에게 UUID 제공
            reservationDate = LocalDate.parse(date);
        }
        return ;                                                //예약 성공 시 예약 객체 반환
    }                                                                      //예약 객체는 고객, 방, 날짜 정보 포함

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }


}
// 예약 // 예약 취소 // 예약 확인 전체 예약확인
