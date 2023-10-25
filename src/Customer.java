import java.util.ArrayList;

public class Customer {
    private String customerName;
    private String customerPhoneNumber;
    private int budget;
    private ArrayList<String> uuid = new ArrayList<>(); // 이것도 뭔가... 한번의 예약에 한개의 uuid를 갖을것같은데...

    public Customer() {} // 디폴트 생성자

    public Customer(String customerName, String customerPhoneNumber, int budget) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
        this.budget = budget;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public void setCustomerPhoneNumber(String customerPhoneNumber) {
        this.customerPhoneNumber = customerPhoneNumber;
    }

    public void setBudget(int budget) {
        this.budget = budget;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerPhoneNumber() {
        return customerPhoneNumber;
    }

    public int getBudget() {
        return budget;
    }

    public void addUuid(String uuid){
        this.uuid.add(uuid);
    }
}
