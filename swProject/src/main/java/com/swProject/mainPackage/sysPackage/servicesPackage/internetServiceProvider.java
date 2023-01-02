package com.swProject.mainPackage.sysPackage.servicesPackage;

import com.swProject.mainPackage.sysPackage.servicesPackage.etisalatPackage.etisalatInternetService;
import com.swProject.mainPackage.sysPackage.servicesPackage.orangePackage.orangeInternetService;
import com.swProject.mainPackage.sysPackage.servicesPackage.vodafonePackage.vodafoneInternetService;
import com.swProject.mainPackage.sysPackage.servicesPackage.wePackage.weInternetService;

public class internetServiceProvider implements serviceProvider{

    public service provideWe(){
        return new weInternetService();
    }

    public service provideVodafone(){
        return new vodafoneInternetService();
    }

    public service provideOrange(){
        return new orangeInternetService();
    }

    public service provideEtisalat(){
        return new etisalatInternetService();
    }

}
