public class Customer {
    private String customerName;
    private String customerPhoneNumber;
    private int budget;
    public Customer(String customerName, String customerPhoneNumber, int budget) {
        this.customerName = customerName;
        this.customerPhoneNumber = customerPhoneNumber;
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

}
