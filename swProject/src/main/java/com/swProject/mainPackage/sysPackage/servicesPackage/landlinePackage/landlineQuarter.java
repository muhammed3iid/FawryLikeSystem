package com.swProject.mainPackage.sysPackage.servicesPackage.landlinePackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public class landlineQuarter extends service implements landlineService {

    public landlineQuarter(){
        serviceName = "quarter landline service";
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
        return new landlineQuarter();
    }

    @Override
    public double getServiceFees() {
        return serviceFees;
    }
}
