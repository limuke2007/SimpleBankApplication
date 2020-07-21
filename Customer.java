package Section8_Arrays_JavaInbuiltList_AutoUnbox.AutoboxingUnboxingChallenge;

import java.util.ArrayList;

public class Customer {

// fields

    private String customerName;
    private ArrayList<Double> transactions;

// constructor

    public Customer(String customerName, double initialAmount) {
        this.customerName = customerName;
        this.transactions = new ArrayList<Double>();        // assign an empty ArrayList to "transactions" field.
        addTransaction(initialAmount);
    }                                                       // when a customer opens an account, there is always
                                                            // an initial amount (assumption)

// methods

    public void addTransaction(double amount) {
        transactions.add(amount);                   // "autoboxing"
    }

    public String getCustomerName() {
        return customerName;
    }

    public ArrayList<Double> getTransactions() {
        return transactions;
    }
}
