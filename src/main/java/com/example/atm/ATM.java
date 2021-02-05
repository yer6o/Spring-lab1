package com.example.atm;

import java.util.Scanner;

public class ATM implements Service {
    private Bank bank;
    private Account account;
    private Scanner in;

    public ATM(Bank bank) {
        this.bank = bank;
        in = new Scanner(System.in);
    }

    public void run() {
        String name;
        int pin;

        System.out.println("Enter user name:");
        name = in.nextLine();

        System.out.println("Enter pin code:");
        pin = in.nextInt();

        if (this.bank.verifyUser(name, pin) != null) {
            this.setAccount(this.bank.verifyUser(name, pin));
            mainMenu();

        } else
            System.out.println("ERROR! Wrong user name or password!");
    }

    public void mainMenu() {
        int x = -1;

        while (x != 0) {
            System.out.println("[1] Show balance");
            System.out.println("[2] Withdraw");
            System.out.println("[3] Top up");
            System.out.println("[0] Exit");

            x = in.nextInt();

            if (x == 1) {
                showBalance();
            } else if (x == 2) {
                System.out.println("Enter value: ");
                double withdraw = in.nextDouble();
                withdraw(withdraw);
            } else if (x == 3) {
                System.out.println("Insert cash: ");
                double topup = in.nextDouble();
                topUp(topup);
            }
        }
    }

    @Override
    public void showBalance() {
        System.out.println(this.account.getBalance());
    }
    @Override
    public void withdraw(double value) {
        this.bank.userWithdraw(this.account.getId(), value);
    }
    @Override
    public void topUp(double value) {
        this.bank.userTopUp(this.account.getId(), value);
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}
