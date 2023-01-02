package com.swProject.mainPackage.sysPackage.userPackage.userModelPackage;
import  com.swProject.mainPackage.sysPackage.servicesPackage.service;
public class request {

    String requesterUsername;
    String status;
    service selectedService;

    public void setSelectedService(service selectedService){
        this.selectedService = selectedService;
    }

    public void setStatus(String status){
        this.status = status;
    }

    public service getSelectedService(){
        return selectedService;
    }

    public String getStatus(){
        return status;
    }

    public void setRequesterUsername(String username){
        requesterUsername = username;
    }

    public String getRequesterUsername(){
        return requesterUsername;
    }
}
