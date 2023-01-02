package com.swProject.mainPackage.sysPackage.servicesPackage.orangePackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public class orangeInternetService extends service implements orangeService {

    public orangeInternetService(){
        serviceName = "orange internet service";
        serviceType = "internet service";
        serviceProvider = "orange";
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
