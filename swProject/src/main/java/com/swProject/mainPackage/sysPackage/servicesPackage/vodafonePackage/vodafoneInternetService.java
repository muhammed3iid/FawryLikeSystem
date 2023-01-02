package com.swProject.mainPackage.sysPackage.servicesPackage.vodafonePackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public class vodafoneInternetService extends service implements vodafoneService {

    public vodafoneInternetService(){
        serviceName = "vodafone internet service";
        serviceType = "internet service";
        serviceProvider = "vodafone";
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
