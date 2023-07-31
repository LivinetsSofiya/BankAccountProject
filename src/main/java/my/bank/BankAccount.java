package my.bank;
public class BankAccount {
    private String accountNumber;
    private double balance;
    public BankAccount(String accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    public double getBalance() {
        return balance;
    }
    public void deposit (double amount){
        if (amount>0){
            balance+=amount;
            System.out.println("Deposid:  $"+ amount);
        }
        else {
            System.out.println("Invalid deposit less than 0. You're broke ");
        }
    }
    public void withdraw (double amount){
        if (amount>0 && amount<=balance){
            balance-=amount;
            System.out.println("Withdrawn:  $"+ amount);
        }else {
            System.out.println("You don't have that much money. Find a job");
        }

    }
}
