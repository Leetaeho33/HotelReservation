import java.util.ArrayList;

public class Customer {
    private String customerName;
    private String customerPhoneNumber;
    private int budget;
    private ArrayList<String> uuid = new ArrayList<>();

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
