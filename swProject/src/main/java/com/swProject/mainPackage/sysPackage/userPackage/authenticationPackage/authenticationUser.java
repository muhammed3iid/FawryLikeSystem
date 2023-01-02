package com.swProject.mainPackage.sysPackage.userPackage.authenticationPackage;
import com.swProject.mainPackage.sysPackage.adminPackage.adminController;
import com.swProject.mainPackage.sysPackage.modelPackage.singleton;
import  com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.user;

public class authenticationUser implements iAuthentication{

    singleton instance;
    adminController myController;

    authenticationUser(){
        instance = singleton.getInstance();
        myController = new adminController();
    }

    @Override
    public user userSignIn(String email, String password){
        for(user u: instance.listOfUsers){
            if(u.getUserData().getEmail().equals(email)){
                return u;
            }
        }
        return null;
    }

    @Override
    public boolean userSignUp(String username, String email, String password){
        user newUser = new user();
        instance.globalId++;
        newUser.setUserId(instance.globalId);
        newUser.getUserData().setUsername(username);
        newUser.getUserData().setEmail(email);
        newUser.getUserData().setPassword(password);
        instance.listOfUsers.add(newUser);
        return true;
    }

}
