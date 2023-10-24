import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Hotel {
    private int asset;
    List<Room> roomList = new ArrayList<>();
    Map<String, Reservation> reservationMap = new HashMap<>();

    public void addRoom(Room room){
        this.roomList.add(room);
    }
}

