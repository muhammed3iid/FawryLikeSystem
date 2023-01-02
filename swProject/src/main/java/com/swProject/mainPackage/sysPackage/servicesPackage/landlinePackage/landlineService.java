package com.swProject.mainPackage.sysPackage.servicesPackage.landlinePackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.service;

public interface landlineService {

    String getServiceName();
    String getServiceType();
    service provideService();

    double getServiceFees();

}
