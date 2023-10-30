import java.util.*;

public class Reservation {
    private Customer customer;
    private Room room;
    private Date reservationDate;
    private String reservationNumber;

    public Reservation() {
    }


    private Reservation(Customer customer, Room room, Date reservationDate) {
        this.customer = customer;
        this.room = room;
        this.reservationDate = reservationDate;
        this.reservationNumber = UUID.randomUUID().toString();
    }

    public String getReservationNumber() {
        return reservationNumber;
    }


    public Reservation makeReservation(Customer customer, Room room, Date date) {
        if (customer.getBudget() > room.getRoomPrice()) {                           //고객의 소지금이 방의 가격보다 많을 때
            if(room.checkRoomReservation(date)) {                                   //해당 날짜에 방이 예약 가능할 때
                room.addRoomDate(date);                                             //예약 성공 시 룸의 date 리스트에 추가.
                return new Reservation(customer, room, date);                       //예약 성공(예약 객체 반환)
            }else {
                System.out.println("해당 날짜에는 예약이 차있습니다.");                   //해당 날짜에 방이 예약 불가능 할 때
                return null;                                                         //예약 실패(null)반환
            }
        }else{
            System.out.println("소지금이 부족합니다.");                                 //고객의 소지금이 방의 가격보다 적을 때
            return null;                                                             //예약 실패(null)반환
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

    public Date getReservationDate() {
        return reservationDate;
    }
}
// 예약 // 예약 취소 // 예약 확인 전체 예약확인
