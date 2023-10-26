import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class View {

    Date customerDate;

    Scanner sc = new Scanner(System.in);

    public void selectMenu() {
        System.out.println("[호텔 예약관리 시스템]");
        System.out.println("--------------------------------------------------------");
        System.out.println("용무에 맞게 선택해주세요");
        System.out.println("1. 객실 예약하기       2. 예약 조회 및 취소     3. 호텔 관리");
    }

    public Customer getCustomerinfo() {
        System.out.println("고객님의 성함을 입력하세요: ");
        String customName = sc.nextLine();
        System.out.println("고객님의 전화번호 입력하세요: ");
        String customPhoneNumber = sc.nextLine();
        System.out.println("고객님의 소지금을 입력하세요: ");
        int customBudget = sc.nextInt();
        sc.nextLine();

        return new Customer(customName, customPhoneNumber, customBudget);
    }

    public void printRoom(Hotel hotel) {
//        while (true) {
//            System.out.println("예약하실 날짜를 입력해주세요 (ex)\"2023-10-25\"형식 : ");
//            //customerDate = inputDate();
//            //if (customerDate != null) break;
//        }
        this.customerDate = new Date();
        System.out.println("customerDate:" + customerDate);
        System.out.println("*** 예약하실 수 있는 객실의 목록입니다. ***\n");
        List<Room> canPossibleRoom =  hotel.getPossibleRoomList(customerDate);
        for (Room hotelRoom : canPossibleRoom) {
            System.out.printf("%-8d%-16s%-10d\n", hotelRoom.getRoomNumber(), hotelRoom.getRoomSize(), hotelRoom.getRoomPrice());
        }

    }

    public void selectRoom() {
        System.out.println("*** 원하시는 객실을 선택해주세요. ***\n");
    }


    public int inputRoomNum(Hotel hotel) {
        int choiceNum = sc.nextInt();
        sc.nextLine();
        Room choiceRoom = hotel.getRoom(choiceNum);
        while (true) {
            if (choiceRoom == null) { //잘못된 방번호일 경우
                System.out.println("잘못된 방 번호입니다. 다시 입력해주세요\n");
                selectRoom();
                choiceNum = sc.nextInt();
                sc.nextLine();
                choiceRoom = hotel.getRoom(choiceNum);
            }
            else //올바론 방번호일경우
            {
                return choiceNum;
            };
        }

    }
    public void printReservationRoom(Hotel hotel, int choice) {
        //선택한 객실 정보 출력
        Room choiceRoom = hotel.getRoom(choice);
        for (Room hotelRoom : hotel.getRoomList()) {
            if (hotelRoom.getRoomNumber() == choice) {
                System.out.printf("%-8d%-16s%-10d\n", choiceRoom.getRoomNumber(), choiceRoom.getRoomSize(), choiceRoom.getRoomPrice());
            }
        }
        System.out.println("*** 선택하신 위 객실로 예약을 진행하시겠습니까? ***\n");
        System.out.println("1. 예약 확인   2. 방 재선택   3. 전체취소\n");

    }


    public void addReservation(Hotel hotel, Customer customer, int roomChoiceNum) {
        Reservation tempReservation = new Reservation();
        Reservation newReservation = tempReservation.makeReservation(customer, hotel.getRoom(roomChoiceNum), this.customerDate);

        if(newReservation == null) {return;}

        System.out.println("*** 예약이 완료되었습니다.***\n");
        System.out.printf("예약번호는 %s 입니다.\n", newReservation.getReservationNumber());
        hotel.addReservation(newReservation);
        //customer에 예약번호 세팅
    }

    public void checkReservation(Hotel hotel) {
        while(true) {
            System.out.println("*** 예약번호를 입력해주세요 ***\n");
            String custom_uuid = sc.nextLine();
            Reservation preReservation = hotel.checkReservationCustomer(custom_uuid);
            if(preReservation != null) {
                System.out.println("*** 해당하는 예약 정보는 다음과 같습니다. ***\n");
                System.out.printf("%-10s %-10s %-10d\n", preReservation.getCustomer().getCustomerName(), preReservation.getCustomer().getCustomerPhoneNumber(), preReservation.getRoom().getRoomNumber());
                break;
            }
            else if(preReservation == null){
                System.out.println("잘못된 예약번호입니다.");
            }
        }

        System.out.println("1. 예약 확인         2. 예약 취소\n");
    }

    public void cancelConfirmReservation() {
        System.out.println(" *** 정말로 취소하시겠습니까? ***\n");
        System.out.println("1. 확인         2. 취소\n");
    }

    public void cancelReservation(Hotel hotel){
        String custom_uuid;
        while(true){
        System.out.println("*** 예약번호를 입력해주세요 ***\n");
        custom_uuid = sc.nextLine();
        Reservation canceledReservation = hotel.checkReservationCustomer(custom_uuid);
        if(canceledReservation != null) {
                System.out.println("잘못된 예약번호입니다.");
                break;
            }
        }
        hotel.removeReservation(custom_uuid);
    }

    public void printAllReservation(Hotel hotel) {
        System.out.println("*** 호텔의 전체 예약 목록입니다. ***\n");
        hotel.checkReservationHotel();
        System.out.println("\n");
        System.out.printf("호텔의 전체 예약 건수 : %d\n", hotel.getReservationCount());
        System.out.printf("보유자산: %d\n",hotel.getAsset());

        System.out.println("다시 돌아가려면 아무키나 입력하세요\n");
    }



    public Date inputDate(){
        String customDate = sc.nextLine();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date date = dateFormat.parse(customDate); // 문자열을 Date로 변환
            String date_str = dateFormat.format(date);
            System.out.println("고객님이 선택하신 날짜는 : " + date_str + "입니다.\n");
            return date;
        } catch (ParseException e) {
            System.out.println("올바른 날짜 형식이 아닙니다.\n");
        }
        return null;
    }
}






