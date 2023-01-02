package com.swProject.mainPackage.sysPackage.userPackage.userModelPackage;
import org.springframework.web.bind.annotation.*;


public class userData {
    private String username;
    private String password;
    private String email;


    userData(){

    }

    public void setUsername(String username){
        this.username = username;
    }


    public String getUsername(){
        return username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return password;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return email;
    }

//    public void setId(int id){
//        this.id = id;
//    }
//
//    public int getId(){
//        return id;
//    }

}
