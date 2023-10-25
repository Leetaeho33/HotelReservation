import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class View {

    Scanner sc = new Scanner(System.in);

    public void selectMenu() {
        System.out.println("[호텔 예약관리 시스템]");
        System.out.println("--------------------------------------------------------");
        System.out.println("용무에 맞게 선택해주세요");
        System.out.println("1. 객실 예약하기       2. 예약 조회 및 취소     3. 호텔 관리");
    }

    public Customer getCustomerinfo(){

        System.out.println("고객님의 성함을 입력하세요: ");
        String customName = sc.nextLine();
        System.out.println("고객님의 전화번호 입력하세요: ");
        String customPhoneNumber = sc.nextLine();
        System.out.println("고객님의 소지금을 입력하세요: ");
        int customBudget = sc.nextInt();
        sc.nextLine();
        Customer newCustom = new Customer(customName,customPhoneNumber,customBudget);
        return newCustom;
    }

    public void printRoom(Hotel hotel) {
        
        System.out.println("*** 예약하실 수 있는 객실의 목록입니다. ***\n");
        for (Room ht_rm : hotel.roomList) {
            System.out.printf("%-8d%-16s%-10d\n", ht_rm.getRoomNumber(), ht_rm.getRoomSize(), ht_rm.getRoomPrice());
        }
    }
        
    public void selectRoom() {
        System.out.println("*** 원하시는 객실을 선택해주세요. ***\n");
    }

    public void confirmReservation(Hotel hotel,int choice) {
        //객실 정보 출력
        System.out.println("*** 위 객실로 예약을 진행하시겠습니까? ***");
        System.out.println("1. 예약 확인   2. 방 재선택   3. 전체취소\n");

    }
    public void printReservationResult(Customer customer) {
        System.out.println("*** 예약이 완료되었습니다.***\n");
        //System.out.printf("%-8d%\n", /* 예약번호*/ );

    }

//            Room NewRoom = null;
//            for (Room ht_rm : hotel.roomList) { ///자기가 선택한 객실 정보보여주기
//                if (ht_rm.getRoomNumber() == HotelRoomNumber) {
//                    System.out.printf("%-8d%-16s%-10d\n", ht_rm.getRoomNumber(), ht_rm.getRoomSize(), ht_rm.getRoomPrice());
//                    NewRoom = new Room(ht_rm.getRoomNumber(), ht_rm.getRoomSize(), ht_rm.getRoomPrice());
//                }
//            }

    public void checkReservation(){

        System.out.println("*** 예약번호를 입력해주세요 ***");
        int custom_uuid = sc.nextInt();
        sc.nextLine();

        // 예약번호에 따른 reservation반환함수 출력

        System.out.println("*** 해당하는 예약 정보는 다음과 같습니다. ***");
        //[ 예약자 이름 ]
        //[ 예약자 전화번호 ]
        //[ 예약 일시 ]
        //[ 예약 룸 정보 ]

        System.out.println("1. 예약 확인         2. 예약 취소");


        }

        public void cancelReservation(){
            System.out.println(" *** 정말로 취소하시겠습니까? ***");
            System.out.println("1. 확인         2. 취소");
        }

    public void printAllReservation(){
        System.out.println("*** 호텔의 전체 예약 목록입니다. ***");
        System.out.println("호텔의 전체 예약 건수 : %d");
        System.out.println("보유자산: %d");

        System.out.println("다시 돌아거려면 아무키나 입력하세요");

    }


}






