import java.util.List;
import java.util.Map;
import java.util.Scanner;


//       스크린: 초기화면
//            |
//  입력: 1. 고객    2. 호텔                      3. 예약확인
//      |               |                              |
//스크린: 객실화면     스크린: 예약목록조회, 총자산           스크린: 고객정보확인
//입력: 객실선택(번호)                                   입력: uuid
//스크린: 고객정보화면                                      스크린: 예약목록
//입력: 고객정보(고객객체)                                         |
//   |             |                                  입력: 1. 확인    2. 취소
//소지금 충분    소지금부족                               스크린: 초기화면   스크린: 초기화면
//   |             |---------스크린:객실화면으로 돌아가기
//스크린:예약확인
//      |
//입력: 1. 예   2. 취소--------스크린:객실화면으로 돌아가기
//       |
//스크린: 예약 완료 && 초기화면으로 돌아가기x


//1) 예약기능 // 3명(태호/규정 소희)
//
//        - 예약 (예약 실패 경우 추가)
//
//        - 예약 확인
//
//        - 예약 취소
//
//        - 전체 예약 확인
//
//        - 예약 가능 객실 리스트 조회기능
//        - 객실리스트/예약 가능한 객실 리스트(날짜별로)/ 예약 된 예약
//        2) 뷰 // 2명 (준영 /유섭)
//
//        - (완)고객 정보 입력페이지(고객 정보 입력)
//        - 예약 페이지에서 (예약, 예약 확인) 1번 누르면 예약, 2번 누르면 예약 확인페이지
//        - 예약 날짜 페이지 ( 날짜입력)
//        - (완)예약 가능 객실 페이지 ( 예약 가능한 객실 리스트 보여주기)
//        - 예약 확인 페이지(예약) - 예약 결정, 예약 실패
//        - 전체예약 확인 페이지
//        날짜에 따른 객실 리스트가 필요가 없다.
//


public class View {

    Scanner sc = new Scanner(System.in);
    public void StartView() {
        System.out.println("[호텔 예약관리 시스템]");
        System.out.println("--------------------------------------------------------");
        System.out.println("용무에 맞게 선택해주세요");
        System.out.println("1. 객실 예약하기       2. 예약 조회 및 취소     3. 호텔 관리");
    }


    public Customer Custominfo(){

        System.out.println("고객님의 성함을 입력하세요: ");
        String customName = sc.nextLine();
        System.out.println("고객님의 전화번호 입력하세요: ");
        String customPhoneNumber = sc.nextLine();
        System.out.println("고객님의 소지금을 입력하세요: ");
        int customBudget = sc.nextInt();

        Customer newCustom = new Customer(customName,customPhoneNumber,customBudget);
        System.out.println("1.예약하기  2.예약 조회하기");

        return newCustom;
    }

    // 예약할 수 있는 객실 보여주기
    // 분기점 1. 유저가 선택한 번호로 객실 예약
    //       2. 취소하기
//    public void EmptyRoomView(Hotel hotel) {
//        //호텔객체에 멤버변수로 Room객체 리스트가 있는거죠
//        System.out.println("*** 예약하실 수 있는 객실의 목록입니다. ***");
//        // 메소드 완성 후 다시 진행
//        // 보여줘야할것 for문 돌리면서 1. 객실 가격 2. 룸사이즈 3. (나중) 예약가능한 룸만
//
//        System.out.println("*** 원하시는 객실을 선택해주세요. ***");
//
//    }

    public void EmptyRoomView(Hotel hotel, Customer customer) {
        boolean check = true;
        while(true) {
            //호텔객체에 멤버변수로 Room객체 리스트가 있는거죠
            System.out.println("*** 예약하실 수 있는 객실의 목록입니다. ***");
            // 메소드 완성 후 다시 진행
            // 보여줘야할것 for문 돌리면서 1. 객실 가격 2. 룸사이즈 3. (나중) 예약가능한 룸만

            System.out.println("*** 원하시는 객실을 선택해주세요. ***");

            int num = sc.nextInt();

            //정보보여주기
            System.out.println();//자기가 선택한 객실 정보 보여주기

            System.out.println("위 객실로 예약을 진행하시겠습니까?");
            System.out.println("1. 예약 확인   2. 예약 취소");


            //소지금 체크
//            check = (choicedRoom.getPrice() > customer.getPrice()) ? true : false;
            System.out.println("----소지금 확인 로직----");
            System.out.println("소지금이 부족합니다.");
            if(check == false) continue;

            int ReservedChoice = sc.nextInt();
            switch (ReservedChoice) {
                case 1:
                    System.out.println("예약이 완료되었습니다.");
                    //예약목록이 추가됩니다.
                    //uuid 반환되야한다.
                    System.out.println("예약번호를 화면에 반환");
                    return;
                case 2:
                    System.out.println("예약이 취소됐습니다.");
                    break;//break
                default:
                    System.out.println("올바르지않은 입력입니다.");
                    break;
            }
        }
    }

    public void searchReservationView(int uid){

        //for문 돌려서 해당하는 uid 객실 search하기

        while(true) {
            System.out.println("해당하는 예약번호 다음과 같습니다.");

            System.out.println("1.확인완료      2.취소하기");

            int checkCancel = sc.nextInt();

            switch (checkCancel) {

                case 1:
                    //
                    return;

                case 2:
                    //취소 구현
                    return;

                default:
                    System.out.println("올바르지않은 입력입니다.");
                    break;

            }
        }


    }


//
//    public void ReserveRoomView(Room myRoom){
//        System.out.println();//자기가 선택한 객실 정보 보여주기
//        System.out.println("위 객실로 예약을 진행하시겠습니까?");
//        System.out.println("1. 예약 확인   2. 예약 취소");
//
//        int ReservedChoice = sc.nextInt();
//
//        if(ReservedChoice == 1) CompleteReservationView(myRoom);
//        else if(ReservedChoice == 2)
//
//
//
//
//    }
//
//    public int CompleteReservationView(Room reservedRoom) {
//        System.out.println("예약이 완료되었습니다.");
//        System.out.println(/*고객님의 예약 번호는 reservedRoom.getuuid 입니다*/);
//    }
//


//    private void showHotelRoom(List<Room> hotelRoom){
//    }
//
//    private void showReservationableHotelRoom(String date){
//
//    }
//
//    private void greeting(){
//
//    }
//    private void


}
