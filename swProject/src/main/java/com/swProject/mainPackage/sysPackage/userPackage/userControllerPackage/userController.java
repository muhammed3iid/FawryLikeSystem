package com.swProject.mainPackage.sysPackage.userPackage.userControllerPackage;

import com.swProject.mainPackage.sysPackage.modelPackage.Response;
import com.swProject.mainPackage.sysPackage.modelPackage.singleton;
import com.swProject.mainPackage.sysPackage.servicesPackage.service;
import com.swProject.mainPackage.sysPackage.userPackage.paymentPackage.payment;
import com.swProject.mainPackage.sysPackage.userPackage.paymentPackage.paymentCreditCard;
import com.swProject.mainPackage.sysPackage.userPackage.paymentPackage.paymentWallet;
import com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.request;
import com.swProject.mainPackage.sysPackage.userPackage.userModelPackage.user;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedList;

@RestController
@RequestMapping("/userController")
public class userController {

    singleton instance;
    LinkedList<user> listOfUsers;

    public userController(){
        instance = singleton.getInstance();
        listOfUsers = instance.listOfUsers;
    }

    @GetMapping("/searchServices/{searchKey}")
    public Response<LinkedList<service>> searchServices(@PathVariable("searchKey") String searchKey){
        LinkedList<service> list = new LinkedList<>();
        Response<LinkedList<service>> response = new Response<>();
        response.setStatus(false);
        for(service s: instance.listOfServices){
            if(s.getServiceName().contains(searchKey)){
                list.add(s);
                response.setStatus(true);
                response.setMsg("Services Retrieved Successfully.");
            }
        }
        if(!response.isStatus()){
            response.setMsg("No service found with current search key.");
            return response;
        }
        response.object = list;
        return response;
    }

    @PutMapping("/addWalletBalance/{userID}/{balance}")
    public Response addWalletBalance(@PathVariable("userID") int id, @PathVariable("balance") double amount){
        Response response = new Response();
        for(user u :listOfUsers){
            if(u.getUserId()==id){
                if(amount<u.getCreditCard().getBalance()){
                    u.getWallet().setBalance(u.getWallet().getBalance()+amount);
                    u.getCreditCard().setBalance(u.getCreditCard().getBalance()-amount);
                    response.setStatus(true);
                    response.setMsg("Transaction done successfully.");
                }
                else{
                    response.setStatus(false);
                    response.setMsg("Transaction failed.");
                }
                return response;
            }
            else{
                response.setStatus(false);
                response.setMsg("No user with the given ID found.");
            }
        }
        return response;
    }

    @GetMapping("/showAppliedServices/{userID}")
    public Response<LinkedList<service>> showAppliedServices(@PathVariable("userID") int id){
        LinkedList<service> list = new LinkedList<>();
        Response<LinkedList<service>> response = new Response<>();
        for(user u: listOfUsers){
            if(u.getUserId() == id){
                if(u.numOfServices > 0){
                    list = u.listOfAppliedServices;
                    response.setStatus(true);
                    response.setMsg("Services Retrieved Successfully.");
                    response.object = list;
                }
                else{
                    response.setStatus(false);
                    response.setMsg("No services found.");
                }
                return response;
            }
            else{
                response.setStatus(false);
                response.setMsg("No user with the given ID found.");
            }
        }
        return response;
    }

    @PostMapping("/registerService/{userID}/{service}/{paymentMethod}")
    public Response registerService(@PathVariable ("userID") int id,@PathVariable ("service") String service,@PathVariable ("paymentMethod") String payMethod){
        Response response = new Response();
        if(payMethod.equals("wallet")){
            payment payment = new paymentWallet();
            if(payment.pay(service,id)){
                response.setStatus(true);
                response.setMsg("Transaction done successfully.");
            }
            else{
                response.setStatus(false);
                response.setMsg("Transaction failed.");
            }
        }
        else if(payMethod.equals("credit card")) {
            payment payment = new paymentCreditCard();
            if(payment.pay(service,id)){
                response.setStatus(true);
                response.setMsg("Transaction done successfully.");
            }
            else{
                response.setStatus(false);
                response.setMsg("Transaction failed.");
            }
        }
        else{
            response.setStatus(false);
            response.setMsg("No user with the given ID found.");
        }
        return response;
    }

    @PostMapping("/requestRefund/{userID}/{service}")
    public Response requestRefund(@PathVariable("userID") int id, @PathVariable("service") String chosenService){
        Response response = new Response();
        for(user u: listOfUsers){
            if(u.getUserId()==id){
                if(u.numOfServices == 0){
                    response.setStatus(false);
                    response.setMsg("No services found.");
                    return response;
                }
                for(service s: instance.listOfServices){
                    if(chosenService.equals(s.getServiceName())){
                        request newRequest = new request();
                        newRequest.setStatus("waiting");
                        newRequest.setSelectedService(s);
                        newRequest.setRequesterUsername(u.getUserData().getUsername());
                        u.listOfUserRequests.add(newRequest);
                        response.setStatus(true);
                        response.setMsg("Request sent successfully.");
                        return response;
                    }
                    response.setStatus(false);
                    response.setMsg("No service applied with given name.");
                }
            }
            else{
                response.setStatus(false);
                response.setMsg("No user with the given ID found.");
            }
        }
        return response;
    }

}
