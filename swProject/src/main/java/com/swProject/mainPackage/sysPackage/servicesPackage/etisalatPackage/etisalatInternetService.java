package com.swProject.mainPackage.sysPackage.servicesPackage.etisalatPackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public class etisalatInternetService extends service implements etisalatService {

    public etisalatInternetService(){
        serviceName = "etisalat internet service";
        serviceType = "internet service";
        serviceProvider = "etisalat";
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
    public String getServiceProvider(){
        return serviceProvider;
    }

    @Override
    public double getServiceFees() {
        return serviceFees;
    }

}
