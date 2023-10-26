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
        if (this.customer.getBudget() < this.room.getRoomPrice()) {
            System.out.println("소지금이 부족합니다.");
            return null;
        } else {
            return new Reservation(customer, room, date);
        }
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }

}
// 예약 // 예약 취소 // 예약 확인 전체 예약확인
