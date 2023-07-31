package my.bank;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BankAccountTest {
    private BankAccount account;

    @BeforeEach
    public void setUp() {
        account = new BankAccount("100000");
    }

    @Test
    public void testInitialBalance() {
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void testDeposit() {
        account.deposit(100);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testInvalidDeposit() {
        account.deposit(-50);
        assertEquals(0.0, account.getBalance());
    }

    @Test
    public void testWithdraw() {
        account.deposit(200);
        account.withdraw(100);
        assertEquals(100.0, account.getBalance());
    }

    @Test
    public void testWithdrawInsufficientFunds() {
        account.deposit(50);
        account.withdraw(100);
        assertEquals(50.0, account.getBalance());
    }
}
