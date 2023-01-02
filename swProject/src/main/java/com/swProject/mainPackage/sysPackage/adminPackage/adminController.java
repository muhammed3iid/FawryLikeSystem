package com.swProject.mainPackage.sysPackage.adminPackage;

import com.swProject.mainPackage.sysPackage.modelPackage.Response;
import com.swProject.mainPackage.sysPackage.modelPackage.singleton;
import com.swProject.mainPackage.sysPackage.userPackage.authenticationPackage.guest;
import com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.request;
import com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.user;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/adminController")
public class adminController {

    singleton instance;
    LinkedList<user> listOfUsers;

    public adminController(){
        instance = singleton.getInstance();
        listOfUsers = instance.listOfUsers;
    }

    @PostMapping("/addUser/{username}/{password}/{email}")
    public Response addUser(@PathVariable("username") String username, @PathVariable("password") String password,@PathVariable("email") String email){
        Response response = new Response();
        guest myUser = new guest();
        if(myUser.guestSignUp(username, email, password)){
            response.setStatus(true);
            response.setMsg("User created Successfully.");
            return response;
        }
        response.setStatus(false);
        response.setMsg("Username or email already taken.");
        return response;
    }

    @GetMapping("/getUser/{userID}")
    public Response<user> getUser(@PathVariable("userID") int id){
        Response<user> response =  new Response<>();
        for(user u: listOfUsers){
            if(u.getUserId()==id){
                response.setStatus(true);
                response.setMsg("User retrieved successfully.");
                response.object = u;
                return response;
            }
            response.setStatus(false);
            response.setMsg("No user found with given id");
        }
        return response;
    }

    @GetMapping("/getAllUsers")
    public Response<LinkedList<user>> getAllUsers(){
        Response<LinkedList<user>> response = new Response<>();
        if(listOfUsers.isEmpty()){
            response.setStatus(false);
            response.setMsg("No users found.");
            return response;
        }
        response.setStatus(true);
        response.setMsg("All users retrieved successfully.");
        response.object = listOfUsers;
        return response;
    }

    @GetMapping("/viewUsersRequests")
    public Response viewUsersRequests(){
        LinkedList<request> list = new LinkedList<>();
        Response<LinkedList> response = new Response<>();
        for(user u: instance.listOfUsers){
            if (!u.listOfUserRequests.isEmpty()){
                for(request r: u.listOfUserRequests){
                    list.add(r);
                }
            }
        }
        if(list.isEmpty()){
            response.setStatus(false);
            response.setMsg("No requests found.");
            return response;
        }
        response.setStatus(true);
        response.setMsg("All requests retrieved.");
        response.object = list;
        return response;
    }

}
