package com.swProject.mainPackage.sysPackage.userPackage.userModelPackage;

public class userCreditCard {

    double balance;

    userCreditCard(){
        balance = 1000;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

}
