package my.bank;


public class Main {
    public static void main (String[] args){
        BankAccount account = new BankAccount("100000");
        account.deposit(100);
        account.withdraw(101);
        System.out.println("Current balance: $"+account.getBalance());
    }
}