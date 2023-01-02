package com.swProject.mainPackage.sysPackage.userPackage.paymentPackage;
import com.swProject.mainPackage.sysPackage.modelPackage.singleton;
import  com.swProject.mainPackage.sysPackage.servicesPackage.*;
import com.swProject.mainPackage.sysPackage.servicesPackage.discountsPackage.discounter;
import com.swProject.mainPackage.sysPackage.servicesPackage.discountsPackage.overallDiscounter;
import  com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.user;
public class paymentWallet implements payment{

    singleton instance;
    discounter discount;

    public paymentWallet(){
        instance = singleton.getInstance();
    }

    @Override
    public boolean pay(String chosenService, int id){
        for(user u: instance.listOfUsers){
            if(u.getUserId() == id){
                for(service s: instance.listOfServices) {
                    if (s.getServiceName().equals(chosenService)) {
                        if(u.numOfServices == 0) {
                            discount = new overallDiscounter(s);
                            if (u.getWallet().getBalance() - discount.getServiceFees() >= 0) {
                                u.getWallet().setBalance(u.getWallet().getBalance() - discount.getServiceFees());
                                u.listOfAppliedServices.add(s);
                                u.numOfServices++;
                                return true;
                            }else {
                                return false;
                            }
                        }else{
                            if (u.getWallet().getBalance() - s.getServiceFees() >= 0) {
                                u.getWallet().setBalance(u.getWallet().getBalance() - s.getServiceFees());
                                u.listOfAppliedServices.add(s);
                                u.numOfServices++;
                                return true;
                            }
                            else{
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

}
