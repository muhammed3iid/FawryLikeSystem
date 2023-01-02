package com.swProject.mainPackage.sysPackage.userPackage.authenticationPackage;
import  com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.user;

public interface iAuthentication {
    user userSignIn(String username, String password);
    boolean userSignUp(String username, String email, String password);
}
