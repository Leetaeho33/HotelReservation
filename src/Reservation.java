import java.util.*;

public class Reservation {
    private Customer customer;
    private Room room;
    Date reservationDate;
    private String reservationNumber;

    private Reservation(Customer customer, Room room, Date reservationDate) {
        this.customer = customer;
        this.room = room;
        this.reservationDate = reservationDate;
        this.reservationNumber = UUID.randomUUID().toString();
    }

    public String getReservationNumber() {
        return reservationNumber;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Room getRoom() {
        return room;
    }
}
