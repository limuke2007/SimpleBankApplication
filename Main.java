package Section8_Arrays_JavaInbuiltList_AutoUnbox.AutoboxingUnboxingChallenge;

import java.util.Scanner;

public class Main {

    private static Scanner scanner = new Scanner(System.in);
    private static Bank myBank = new Bank("Mid First");


    public static void main(String[] args) {

        boolean quit=false;
        startBank();
        printOptions();


        while (!quit) {
            System.out.println("\nEnter option: (6 to show available options)");
            int option=scanner.nextInt();
            scanner.nextLine();

            switch(option) {
                case 0:
                    System.out.println("Exiting...");
                    quit=true;
                    break;
                case 1:
                    addNewBranch();
                    break;
                case 2:
                    addNewCustomer();
                    break;
                case 3:
                    addNewTransaction();
                    break;
                case 4:
                    myBank.printBranches();
                    break;
                case 5:
                    printCustomerList();
                    break;
                case 6:
                    printOptions();
                    break;
            }
        }
    }

    private static void startBank() {
        System.out.println("Welcome to Mid First Bank!");
    }

    private static void printOptions() {
        System.out.println("\nAvailable Options:\nPress");
        System.out.println("0 - to Exit\n" +
                "1 - to add a new branch\n" +
                "2 - to add a new customer\n" +
                "3 - to add a new transaction for a customer\n" +
                "4 - to print branches\n" +
                "5 - to print customer list for a branch\n" +   // show transactions?
                "6 - to print available options.");
        System.out.println("Choose your option: ");
    }

    private static void printCustomerList() {
        System.out.println("Enter branch name: ");
        String branchName=scanner.nextLine();
        System.out.println("Show customer transactions? (true / false)");
        boolean showTransactions = scanner.nextBoolean();
        scanner.nextLine();
        myBank.listCustomers(branchName, showTransactions);
    }

    private static void addNewBranch() {
        System.out.println("Enter new branch name: ");
        String newBranchName = scanner.nextLine();
        myBank.addNewBranch(newBranchName);
    }

    private static void addNewCustomer() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter initial amount: ");
        double initialAmount = scanner.nextDouble();
        scanner.nextLine();
        myBank.addBranchCustomer(branchName, customerName, initialAmount);
    }

    private static void addNewTransaction() {
        System.out.println("Enter branch name: ");
        String branchName = scanner.nextLine();
        System.out.println("Enter customer name: ");
        String customerName = scanner.nextLine();
        System.out.println("Enter transaction amount: ");
        double transaction = scanner.nextDouble();
        scanner.nextLine();
        myBank.addCustomerTransactions(branchName, customerName, transaction);
    }

//    public static void main(String[] args) {
//
//        Bank bank = new Bank("Mid First");
//        bank.addNewBranch("OKC");
//        bank.addBranchCustomer("OKC","Limu",50.00);
//        bank.addBranchCustomer("OKC", "Aka", 100.00);
//        bank.addBranchCustomer("OKC", "Kerim", 200.00);
//
//        bank.addNewBranch("Stillwater");
//        bank.addBranchCustomer("Stillwater", "Mike", 70.00);
//        bank.addBranchCustomer("Stillwater", "Jim", 40.00);
//
//        bank.addCustomerTransactions("OKC", "Limu", 500.00);
//        bank.addCustomerTransactions("OKC", "Aka", 1000.00);
//        bank.addCustomerTransactions("OKC", "Limu", 750.75);
//
//        bank.printBranches();
//        bank.printCustomerList("OKC", false);
//
//        bank.addNewBranch("OKC");
//        bank.addBranchCustomer("Tulsa", "Bob", 50.00);
//
//        bank.addBranchCustomer("OKC", "Limu", 10.00);
//        bank.addCustomerTransactions("Stillwater", "Aka", 80.00);
//    }

}
