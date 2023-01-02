package com.swProject.mainPackage.sysPackage.servicesPackage.landlinePackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public class landlineMonthly extends service implements landlineService{

    public landlineMonthly(){
        serviceName = "monthly landline service";
        serviceType = "landline service";
        serviceFees = 100;
    }

    @Override
    public String getServiceName(){
        return serviceName;
    }

    @Override
    public String getServiceType(){
        return serviceType;
    }

    @Override
    public String getServiceProvider() {
        return null;
    }

    @Override
    public service provideService(){
        return new landlineMonthly();
    }

    @Override
    public double getServiceFees() {
        return serviceFees;
    }

}
