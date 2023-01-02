package com.swProject.mainPackage.sysPackage.modelPackage;
import com.swProject.mainPackage.sysPackage.servicesPackage.*;
import com.swProject.mainPackage.sysPackage.servicesPackage.landlinePackage.landlineMonthly;
import com.swProject.mainPackage.sysPackage.servicesPackage.landlinePackage.landlineQuarter;
import com.swProject.mainPackage.sysPackage.servicesPackage.landlinePackage.landlineService;
import com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.user;

import java.util.LinkedList;

public class singleton {

    private static singleton instance;
    public int globalId;
    public LinkedList<user> listOfUsers;
    public LinkedList<service> listOfServices;
    serviceProvider mobileProvider;
    serviceProvider internetProvider;
    landlineService landlineProvider;

    private singleton() {

        globalId = 0;
        listOfUsers = new LinkedList<>();
        listOfServices = new LinkedList<>();

        internetProvider = new internetServiceProvider();
        listOfServices.add(internetProvider.provideEtisalat());
        listOfServices.add(internetProvider.provideOrange());
        listOfServices.add(internetProvider.provideVodafone());
        listOfServices.add(internetProvider.provideWe());
        mobileProvider = new mobileServiceProvider();
        listOfServices.add(mobileProvider.provideEtisalat());
        listOfServices.add(mobileProvider.provideOrange());
        listOfServices.add(mobileProvider.provideVodafone());
        listOfServices.add(mobileProvider.provideWe());
        landlineProvider = new landlineMonthly();
        listOfServices.add(landlineProvider.provideService());
        landlineProvider = new landlineQuarter();
        listOfServices.add(landlineProvider.provideService());

    }

    public static singleton getInstance() {
        if (instance == null) {
            instance = new singleton();
        }
        return instance;
    }

}
