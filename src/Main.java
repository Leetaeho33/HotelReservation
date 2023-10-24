
import java.util.Scanner;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    Hotel hotel = new Hotel();
    public static void main(String[] args) {


        Scanner sc = new Scanner(System.in);
        View consoleView = new View();
        Hotel hotel = new Hotel();




        while (true) {
            //시작 화면
            consoleView.StartView();//예약, 예약조회,호텔관리 체크하는 분기
            int checkCustom = sc.nextInt();
            Customer customer = new Customer();

            switch (checkCustom) {

                case 1:
                    customer = consoleView.Custominfo(); // 고객정보를 입력받는 view
                    consoleView.EmptyRoomView(hotel, customer);
                    System.out.println("예약 기능 작동");
                    break;

                case 2: // 예약수정 및 조회
                    consoleView.searchReservationView(/*uuid*/);
                    break;


                case 3: // 호텔관리
                    break;


                default:
                    System.out.println("해당하지않는 번호입니다.");
                    break;


            }
        }
    }


    public void init () {
        Room standard_101 = new Room(101, "Standard", 5);
        Room standard_102 = new Room(102, "Standard", 5);
        Room standard_103 = new Room(103, "Standard", 5);
        Room standard_104 = new Room(104, "Standard", 5);
        Room standard_105 = new Room(105, "Standard", 5);
        hotel.addRoom(standard_101);
        hotel.addRoom(standard_102);
        hotel.addRoom(standard_103);
        hotel.addRoom(standard_104);
        hotel.addRoom(standard_105);

        Room twin_201 = new Room(201, "Twin", 10);
        Room twin_202 = new Room(202, "Twin", 10);
        Room twin_203 = new Room(203, "Twin", 10);
        Room twin_204 = new Room(204, "Twin", 10);
        Room twin_205 = new Room(205, "Twin", 10);
        hotel.addRoom(twin_201);
        hotel.addRoom(twin_202);
        hotel.addRoom(twin_203);
        hotel.addRoom(twin_204);
        hotel.addRoom(twin_205);

        Room deluxe_301 = new Room(301, "Deluxe", 15);
        Room deluxe_302 = new Room(302, "Deluxe", 15);
        Room deluxe_303 = new Room(303, "Deluxe", 15);
        Room deluxe_304 = new Room(304, "Deluxe", 15);
        Room deluxe_305 = new Room(305, "Deluxe", 15);
        hotel.addRoom(deluxe_301);
        hotel.addRoom(deluxe_302);
        hotel.addRoom(deluxe_303);
        hotel.addRoom(deluxe_304);
        hotel.addRoom(deluxe_305);

        Room suite_401 = new Room(401, "Suite", 40);
        Room suite_402 = new Room(402, "Suite", 40);
        Room suite_403 = new Room(403, "Suite", 40);
        Room suite_404 = new Room(404, "Suite", 40);
        Room suite_405 = new Room(405, "Suite", 40);
        hotel.addRoom(suite_401);
        hotel.addRoom(suite_402);
        hotel.addRoom(suite_403);
        hotel.addRoom(suite_404);
        hotel.addRoom(suite_405);
    }



}

//1) 예약기능 // 3명(태호/규정 소희)
//
// - 예약 (예약 실패 경우 추가)
//
// - 예약 확인
//
// - 예약 취소
//
// - 전체 예약 확인
//
//- 예약 가능 객실 리스트 조회기능
//- 객실리스트/예약 가능한 객실 리스트/ 예약 된 예약
//2) 뷰 // 2명 (준영 /유섭)
//
//- 고객 정보 입력페이지(고객 정보 입력)
//- 예약 페이지에서 (예약, 예약 확인) 1번 누르면 예약, 2번 누르면 예약 확인페이지
//- 예약 날짜 페이지 ( 날짜입력)
//- 예약 가능 객실 페이지 ( 예약 가능한 객실 리스트 보여주기)
//- 예약 확인 페이지(예약) - 예약 결정, 예약 실패
//- 전체예약 확인 페이지
//날짜에 따른 객실 리스트가 필요가 없다.