import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private int asset;
    private List<Room> roomList = new ArrayList<>();
    private Map<String, Reservation> reservationMap = new HashMap<>();

    public void addRoom(Room room){
        this.roomList.add(room);
    }

    public void addReservation(Reservation reservation){
        reservationMap.put(reservation.getReservationNumber(), reservation);
        // 호텔 자산 추가 로직 구현
    }
}

