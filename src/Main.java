
import java.util.Scanner;
public class Main {
    static Hotel hotel = new Hotel();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        View consoleView = new View();
        init();
        while (true) {
            //시작 화면
            consoleView.selectMenu();//예약, 예약조회,호텔관리 체크하는 분기
            int checkCustom = sc.nextInt();
            sc.nextLine();//버퍼지워두기

            switch (checkCustom) {
                case 1:
                    Customer customer = consoleView.getCustomerinfo(); // 고객정보를 입력받는 view
                    while (true) {
                        consoleView.printRoom(hotel);
                        consoleView.selectRoom();
                        int selectRoomNum = sc.nextInt();
                        sc.nextLine();
                        consoleView.confirmReservation(hotel, selectRoomNum);//
                        int confirmCheck = sc.nextInt();
                        sc.nextLine();
                        if (confirmCheck == 1) {
                            //예약리스트에 add하는 메서드
                            consoleView.addReservation(hotel,customer,selectRoomNum);
                            break;
                        } else if (confirmCheck == 2) {
                            continue;
                        } else {
                            break;
                        }
                    }
                    break;

                case 2: // 예약수정 및 조회
                    consoleView.checkReservation(hotel);
                    int confirmReservationSearch = sc.nextInt(); //예약조회 후 확인 or 취소 선택분기
                    sc.nextLine();

                    if (confirmReservationSearch == 1) {
                        break;
                    } else if (confirmReservationSearch == 2) {
                        consoleView.cancelConfirmReservation();
                        int cancelConfirm = sc.nextInt();
                        sc.nextLine();
                        if (cancelConfirm == 1) {
                            // 예약정보를 지우는 부분
                            consoleView.cancelReservation(hotel);
                            break;
                        } else if (cancelConfirm == 2) {
                            break;
                            //시작화면으로
                        } else {
                            break;
                        }
                    } else {
                        break;
                    }


                case 3: // 호텔관리
                    consoleView.printAllReservation(hotel);
                    sc.nextLine();
                    break;

                default:
                    System.out.println("해당하지않는 번호입니다.");
                    break;
            }
        }
    }

    public static void init() {
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
