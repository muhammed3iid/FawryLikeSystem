package com.swProject.mainPackage.sysPackage.userPackage.userModelPackage;

public class userWallet {

    double balance;

    userWallet(){
        balance = 500;
    }

    public double getBalance(){
        return balance;
    }

    public void setBalance(double amount){
        balance = amount;
    }

}
