package com.swProject.mainPackage.sysPackage.userPackage.userModelPackage;
import com.swProject.mainPackage.sysPackage.servicesPackage.*;

import java.util.LinkedList;

public class user {

    private userData data;
    private int userId;
    public LinkedList<service> listOfAppliedServices;
    userWallet wallet;
    userCreditCard creditCard;
    public LinkedList<request> listOfUserRequests;
    public int numOfServices;

    public user(){
        data = new userData();
        wallet = new userWallet();
        creditCard = new userCreditCard();
        listOfAppliedServices = new LinkedList<>();
        listOfUserRequests = new LinkedList<>();
        numOfServices = 0;
    }

    public userData getUserData(){
        return data;
    }

    public userWallet getWallet(){
        return wallet;
    }

    public userCreditCard getCreditCard(){
        return creditCard;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int id){
        this.userId = id;
    }


}