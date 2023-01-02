package com.swProject.mainPackage.sysPackage.userPackage.authenticationPackage;
import  com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.user;
public class guest {

    String username;
    String password;
    String email;
    iAuthentication authentication;

    public guest(){
        authentication = new authenticationProxy();
    }

    public user guestSignIn(){
        return authentication.userSignIn(email, password);
    }

    public boolean guestSignUp(String username, String email, String password){
        return authentication.userSignUp(username,email,password);
    }

}
