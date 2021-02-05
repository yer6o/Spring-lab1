package com.example.atm;

public interface Service {
    void showBalance();
    void withdraw(double value);
    void topUp(double value);
}
