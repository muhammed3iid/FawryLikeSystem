package com.swProject.mainPackage.sysPackage.userPackage.authenticationPackage;
import com.swProject.mainPackage.sysPackage.modelPackage.singleton;
import  com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.user;

public class authenticationProxy implements iAuthentication{

    singleton instance;
    authenticationUser authenticate;

    authenticationProxy(){
        authenticate = new authenticationUser();
        instance = singleton.getInstance();
    }

    public boolean checkSignIn(String email, String password){
        for (user u: instance.listOfUsers) {
            if (email.equals(u.getUserData().getEmail())) {
                return password.equals(u.getUserData().getPassword());
            }
        }
        return false;
    }

    @Override
    public user userSignIn(String email, String password) {
        if(checkSignIn(email, password)){
            return authenticate.userSignIn(email, password);
        }
        else{
            return null;
        }
    }

    public boolean checkSignUp(String username, String email){
        for (user u: instance.listOfUsers){
            if (username.equals(u.getUserData().getUsername())) {
                return false;
            }
            if(email.equals(u.getUserData().getEmail())) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean userSignUp(String username, String email, String password){
        if(checkSignUp(username, email)){
            return authenticate.userSignUp(username, email, password);
        }
        else{
            return false;
        }
    }

}
