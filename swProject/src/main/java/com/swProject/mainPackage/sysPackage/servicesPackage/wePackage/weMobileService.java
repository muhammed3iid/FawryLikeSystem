package com.swProject.mainPackage.sysPackage.servicesPackage.wePackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public class weMobileService extends service implements weService {

    public weMobileService(){
        serviceName = "we mobile service";
        serviceType = "mobile service";
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
