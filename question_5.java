// question no 5

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.logging.Level;
import java.util.logging.Logger;

class Transaction {

    private double total = 0.0;

    public void withdraw(double amount) {
        total -= amount;

    }

    public void deposit(double amount) {
        total += amount;
    }

    public double getAccount() {
        return total;

    }
}

class TransactionFormCard {

    private static final Lock lock = new ReentrantLock();
    private Condition myCond = lock.newCondition();
    Transaction myAccount;

    public TransactionFormCard(Transaction myAccount) {
        this.myAccount = myAccount;
    }

    public void amountWithdrawn(double money_Withdrawn)
            throws InterruptedException {
        lock.lock();
        try {
            if (money_Withdrawn > myAccount.getAccount()) {
                myCond.await();
            }
            // when the condition is satisfied then :
            System.out.println("Amount Withdrawn is " + money_Withdrawn);
            myAccount.withdraw(money_Withdrawn);
            System.out.println("Total Amount of card is " + myAccount.getAccount());
            System.out.println("\n");
        } finally {
            lock.unlock();
        }
    }

    public void amountDeposited(double money_deposited)
            throws InterruptedException {
        lock.lock();
        try {
            System.out.println("Amount Deposited is " + money_deposited);
            myAccount.deposit(money_deposited);
            System.out.println("Total Amount is " + myAccount.getAccount());
            // 
            myCond.signalAll();

        } finally {
            lock.unlock();
        }
    }
}

class DebitCard implements Runnable {

    private TransactionFormCard card;
    private double amount_deposit;
    private double amount_withdraw;

    public DebitCard(TransactionFormCard card, double amount_deposit, double amount_withdraw) {
        this.card = card;
        this.amount_deposit = amount_deposit;
        this.amount_withdraw = amount_withdraw;
    }

    public void run() {
        try {
            card.amountDeposited(amount_deposit);
            card.amountWithdrawn(amount_withdraw);
        } catch (InterruptedException ex) {
            Logger.getLogger(CreditCard.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}

class CreditCard implements Runnable {

    private TransactionFormCard card;
    private double amount_deposit;
    private double amount_withdraw;

    public CreditCard(TransactionFormCard card, double amount_deposit,
            double amount_withdraw) {
        this.card = card;
        this.amount_deposit = amount_deposit;
        this.amount_withdraw = amount_withdraw;
    }

    public void run() {
        try {
            card.amountDeposited(amount_deposit);
            card.amountWithdrawn(amount_withdraw);
        } catch (InterruptedException ex) {
            Logger.getLogger(CreditCard.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}

public class question_5 {

    public static void main(String[] args) throws InterruptedException {

        TransactionFormCard card = new TransactionFormCard(new Transaction());

        DebitCard debitcard = new DebitCard(card, 15000.0, 15000.0);
        CreditCard creditcard = new CreditCard(card, 50000.0, 15000.0);
        Thread thread1 = new Thread(debitcard);
        Thread thread2 = new Thread(creditcard);
        thread1.start();
        thread2.start();
    }
}
