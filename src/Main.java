import java.util.Scanner;

public class Main {

    public static void main(String[] args) {



        Scanner sc = new Scanner(System.in);
        View consoleView = new View();

        while(true) {
            //시작 화면
            consoleView.StartView();//예약, 예약조회,호텔관리 체크하는 분기
            int checkCustom = sc.nextInt();
            Customer customer = new Customer();
            Hotel hotel = new Hotel();
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
}