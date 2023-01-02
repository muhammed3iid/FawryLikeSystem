package com.swProject.mainPackage.sysPackage.servicesPackage;

public abstract class service {
    public String serviceName;
    public String serviceType;
    public String serviceProvider;
    public double serviceFees;

    public abstract String getServiceName();
    public abstract String getServiceType();
    public abstract String getServiceProvider();
    public abstract double getServiceFees();

}
