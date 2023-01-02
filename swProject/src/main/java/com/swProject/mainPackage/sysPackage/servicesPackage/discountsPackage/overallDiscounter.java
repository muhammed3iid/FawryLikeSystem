package com.swProject.mainPackage.sysPackage.servicesPackage.discountsPackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public class overallDiscounter extends discounter{

    service s;
    public overallDiscounter(service s){
        this.s = s;
    }

    @Override
    public String getServiceName() {
        return null;
    }

    @Override
    public String getServiceType() {
        return null;
    }

    @Override
    public String getServiceProvider() {
        return null;
    }

    @Override
    public double getServiceFees(){
        return s.getServiceFees()-(s.getServiceFees()*0.1);
    }

}
