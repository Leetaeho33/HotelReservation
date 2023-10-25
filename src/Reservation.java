import java.util.*;

public class Reservation {
    private Customer customer;
    private Room room;
    Date reservationDate; // 이게 리스트가 아니어도 상관없지 않을까요...?
    Reservation reservation;

    public Reservation makeReservation(Customer customer, Room room, Date date){
        this.customer = customer;                                          //예약 객체의 고객 정보 저장
        this.room = room;                                                  //예약 객체의 방 정보 저장
        if(this.customer.getBudget() > this.room.getRoomPrice()){          //손님의 예산 > 방가격
//          customer.setBudget(customer.getBudget()- room.getRoomPrice()); //예약 성공 시 손님 소지금 삭감  // 황규정 : view에서 보니 준영님과 유섭님이 Customer를
//                                                                              반복해서 받는작업이 있어서.. 회원가입을 만들지 않는다면 소지금을 빼줄 필요가 없을것같습니다..!
            UUID uuid = UUID.randomUUID();                                 //고객에게 제공할 UUID 생성
            customer.addUuid(uuid.toString());                             //예약 성공 시 고객에게 UUID 제공
        }
        return reservation;                                                //예약 성공 시 예약 객체 반환
    }                                                                      //예약 객체는 고객, 방, 날짜 정보 포함

    public void CheckReservationCustomer(Map<String, Reservation> reservationMap,String uuId){
        for(Map.Entry<String, Reservation> entry : reservationMap.entrySet()){
            if(entry.getKey().equals(uuId)){
                System.out.println("Name : " + entry.getValue().customer.getCustomerName() +
                        "Phone Number : " + entry.getValue().customer.getCustomerPhoneNumber() +
                        "Room Number : " + entry.getValue().room.getRoomNumber() +
                        "Reservation Date : " + entry.getValue().reservationDate +
                        "UUID : " + entry.getKey());
            }
        }
    }

    public void CheckReservationHotel(Map<String, Reservation> reservationMap){
        for (Map.Entry<String, Reservation> entry : reservationMap.entrySet()) {
            System.out.println("Name : " + entry.getValue().customer.getCustomerName() +
                    "Phone Number : " + entry.getValue().customer.getCustomerPhoneNumber() +
                    "Room Number : " + entry.getValue().room.getRoomNumber() +
                    "Reservation Date : " + entry.getValue().reservationDate +
                    "UUID : " + entry.getKey());
        }
    }
}
// 예약 // 예약 취소 // 예약 확인 전체 예약확인
