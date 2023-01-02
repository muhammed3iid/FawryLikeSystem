package com.swProject.mainPackage.sysPackage.servicesPackage.wePackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public class weInternetService extends service implements weService {

    public weInternetService(){
        serviceName = "we internet service";
        serviceType = "internet service";
        serviceProvider = "we";
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
