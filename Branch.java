package Section8_Arrays_JavaInbuiltList_AutoUnbox.AutoboxingUnboxingChallenge;

import java.util.ArrayList;

public class Branch {

// fields

    private String branchName;
    private ArrayList<Customer> myCustomers;

// constructor

    public Branch(String branchName) {
        this.branchName = branchName;
        this.myCustomers = new ArrayList<Customer>();
    }

// methods

    public String getBranchName() {
        return branchName;
    }

    public ArrayList<Customer> getMyCustomers() {
        return myCustomers;
    }

    public boolean addNewCustomer(String newCustomerName, double initialAmount) {
        if (findCustomer(newCustomerName)  == null) {
            myCustomers.add(new Customer(newCustomerName, initialAmount) );
            return true;
        }
        System.out.println("Customer is already on file");
        return false;
    }

    public boolean addCustomerTransaction(String customerName, double amount) {
        Customer existingCustomer = findCustomer((customerName));
        if (existingCustomer != null) {
            existingCustomer.addTransaction(amount);
            return true;
        }
        System.out.println("Customer not on file, cannot add transaction");
        return false;
    }


    private Customer findCustomer(String customerName) {
        for (int i=0; i<myCustomers.size();i++) {
            Customer checkedCustomer = myCustomers.get(i);
            if (checkedCustomer.getCustomerName().equals(customerName)) {
                return checkedCustomer;
            }
        }
        return null;
    }
}
