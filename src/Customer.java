import java.util.ArrayList;
import java.util.List;

public class Customer {
    private String customerName;
    private String customerPhoneNumber;
    private int budget;
    private String reservationNumber;

   //  public Customer() {} // 디폴트 생성자

    public Customer(String customerName, String customerPhoneNumber, int budget) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.budget = budget;
    }


    public int getBudget() {
        return budget;
    }
}
