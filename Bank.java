package Section8_Arrays_JavaInbuiltList_AutoUnbox.AutoboxingUnboxingChallenge;

import java.util.ArrayList;

public class Bank {

// fields

    private String bankName;
    private ArrayList<Branch> myBranches;


// constructor

    public Bank(String bankName) {
        this.bankName = bankName;
        this.myBranches = new ArrayList<Branch>();
    }

// methods

    public String getBankName() {
        return bankName;
    }

    public ArrayList<Branch> getMyBranches() {
        return myBranches;
    }

    public boolean addNewBranch(String newBranchName) {
        if (findBranch(newBranchName) == null) {
            myBranches.add(new Branch(newBranchName));
            return true;
        }
        System.out.println("Branch is already on file.");
        return false;
    }

    public boolean addBranchCustomer(String branchName, String customerName, double initialAmount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.addNewCustomer(customerName, initialAmount);      // beauty of OOP
        }                                                                           // 自动检查customer是否存在
        System.out.println("Branch not on file, cannot add customer.");
        return false;
    }

    public boolean addCustomerTransactions(String branchName, String customerName, double amount) {
        Branch existingBranch = findBranch(branchName);
        if (existingBranch != null) {
            return existingBranch.addCustomerTransaction(customerName, amount);     // beauty of OOP
        }                                                                           // 自动检查customer是否存在
        System.out.println("Branch not on file, cannot add transaction.");
        return false;
    }

    private Branch findBranch(String branchName) {
        for (int i=0; i< myBranches.size(); i++) {
            Branch checkedBranch = myBranches.get(i);
            if (checkedBranch.getBranchName().equals(branchName)) {
                return checkedBranch;
            }
        }
        return null;
    }

    public void printBranches() {
        System.out.println("Branches List: ");
        for (int i=0; i<myBranches.size(); i++) {
            System.out.println( (i + 1) + ". " + myBranches.get(i).getBranchName());
        }
    }

    public boolean listCustomers(String branchName, boolean showTransactions) {
        Branch currentBranch = findBranch(branchName);
        if (currentBranch != null) {
            System.out.println("Customer List for branch " + currentBranch.getBranchName());
            ArrayList<Customer> currentBranchCustomers = currentBranch.getMyCustomers();
            for (int i = 0; i < currentBranchCustomers.size(); i++) {
                Customer currentCustomer = currentBranchCustomers.get(i);
                System.out.println("Customer " + (i + 1) + ". " + currentCustomer.getCustomerName());
                if (showTransactions) {
                    System.out.println("Transactions for customer " + currentCustomer.getCustomerName());
                    ArrayList<Double> currentCustomerTransactions = currentCustomer.getTransactions();
                    for (int j = 0; j < currentCustomerTransactions.size(); j++) {
                        System.out.println((j + 1) + " ." + currentCustomerTransactions.get(j));
                    }
                }
            }
            return true;
        } else {
            return false;
        }
    }
}
