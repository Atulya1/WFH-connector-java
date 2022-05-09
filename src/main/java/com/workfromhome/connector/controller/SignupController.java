package com.workfromhome.connector.controller;

import com.mongodb.BasicDBObject;
import com.workfromhome.connector.model.LoginDetails;
import com.workfromhome.connector.model.ResponseClass;
import com.workfromhome.connector.model.SignupDetails;
import com.workfromhome.connector.repository.SignupRepository;

import java.util.List;


public class SignupController {


    public ResponseClass saveDetails(SignupRepository signupRepository, SignupDetails signupDetails) throws Exception {
        try{
            System.out.println(signupDetails.toString());
            signupRepository.save(signupDetails);
        } catch(Exception e) {
            throw new Exception("Exception : "+e.getMessage());
        }
        return new ResponseClass(200, "Saved Successfully");
    }

    public ResponseClass loginUser(SignupRepository signupRepository, LoginDetails loginDetails) throws Exception {
        try {
            if(loginDetails.getEmailId() != "") {
                if(!signupRepository.findByEmailId(loginDetails.getEmailId()).isEmpty()) {
                    List<SignupDetails> list = signupRepository.findByEmailId(loginDetails.getEmailId());
                    if(list.get(0).getPassword().equals(loginDetails.getPassword())) {
                        return new ResponseClass(200, "LoggedIn Successfully");
                    } else {
                        return new ResponseClass(404, "Password Incorrect");
                    }
                } else {
                    return new ResponseClass(404, "Email not present");
                }
            } else if(loginDetails.getPhoneNumber() != "") {
                if (!signupRepository.findByMobileNumber(loginDetails.getPhoneNumber()).isEmpty()) {
                    List<SignupDetails> list = signupRepository.findByMobileNumber(loginDetails.getPhoneNumber());
                    if(list.get(0).getPassword().equals(loginDetails.getPassword())) {
                        return new ResponseClass(200, "LoggedIn Successfully");
                    } else {
                        return new ResponseClass(404, "Password Incorrect");
                    }
                } else {
                    return new ResponseClass(404, "Mobile Number Not present");
                }
            }
        } catch(Exception e) {
            throw new Exception("Exception : "+e.getMessage());
        }
        return new ResponseClass(404, "Something went wrong");
    }
}
