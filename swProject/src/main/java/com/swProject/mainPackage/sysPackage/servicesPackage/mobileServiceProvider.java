package com.swProject.mainPackage.sysPackage.servicesPackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.etisalatPackage.etisalatMobileService;
import com.swProject.mainPackage.sysPackage.servicesPackage.orangePackage.orangeMobileService;
import com.swProject.mainPackage.sysPackage.servicesPackage.vodafonePackage.vodafoneMobileService;
import com.swProject.mainPackage.sysPackage.servicesPackage.wePackage.weMobileService;

public class mobileServiceProvider implements serviceProvider{

    public service provideWe(){
        return new weMobileService();
    }

    public service provideVodafone(){
        return new vodafoneMobileService();
    }

    public service provideOrange(){
        return new orangeMobileService();
    }

    public service provideEtisalat(){
        return new etisalatMobileService();
    }

}
