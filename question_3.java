package finalassignment;

import java.util.Scanner;

class Account implements Runnable {

    int balance;
    int preTransaction;
    String customerName;
    String customerId;
    boolean isVerified = true;

    Account() {
        balance = 6000;
    }

    public void run() {

        deposit(2000);
        if (getBalance() < 0) {
            System.out.println("account is overdrawn!");

        }

    }

    public synchronized void deposit(int amount) {
        Scanner userInput = new Scanner(System.in);
        System.out.println("Are you verified your account?true/false: ");
        boolean booleanValue = userInput.nextBoolean();

        if (isVerified == booleanValue) {
            System.out.println("You are able to make money transactions.");
            System.out.println(Thread.currentThread().getName() + " is going to withdraw " + amount);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                System.out.println("Invalid input!");
            }

        } else {
            System.out.println("please, verified your account.\nwe sent you a SMS through the mobile phone. ");
        }
    }

    public int getBalance() {
        return balance;
    }

    public void withdraw(int amount) {
        if (amount != 0) {
            balance = balance - amount;
            preTransaction = -amount;
        }
    }

    void getPreTransaction() {
        if (preTransaction > 0) {
            System.out.println("Deposited: " + preTransaction);
        } else if (preTransaction < 0) {
            System.out.println("Withdrawn: " + Math.abs(preTransaction));
        } else {
            System.out.println("No transaction occured");
        }
    }

}

public class question_3 {

    public static void main(String[] args) {

        Account acc = new Account();
        Thread t1 = new Thread(acc);
        Thread t2 = new Thread(acc);

        t1.setName("user-1");
        t1.start();
        t2.setName("user-2");
        t2.start();

    }
}
