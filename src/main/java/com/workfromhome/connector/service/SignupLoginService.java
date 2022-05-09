package com.workfromhome.connector.service;

import com.workfromhome.connector.controller.SignupController;
import com.workfromhome.connector.model.LoginDetails;
import com.workfromhome.connector.model.ResponseClass;
import com.workfromhome.connector.model.SignupDetails;
import com.workfromhome.connector.repository.SignupRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class SignupLoginService {

    @Autowired
    private SignupRepository signupRepository;

    SignupController s = new SignupController();

    @PostMapping("/login")
    public ResponseClass login(@RequestBody LoginDetails loginDetails){
        try {
            System.out.println(loginDetails.toString());
            return s.loginUser(signupRepository, loginDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseClass(404,"failed");
        }
    }

    @PostMapping("/signup")
    public ResponseClass signup(@RequestBody SignupDetails signupDetails) {
        try {
            return s.saveDetails(signupRepository, signupDetails);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseClass(404,"failed");
        }
    }

    @PostMapping("/signupWithGoogle")
    public String signupWithGoogle(@RequestBody SignupDetails signupDetails){
        return "";
    }

    @PostMapping("/signupWithLinkedIn")
    public String signupWithLinkedIn(@RequestBody SignupDetails signupDetails){
        return "";
    }

    @PostMapping("/loginWithGoogle")
    public String loginWithGoogle(@RequestBody SignupDetails signupDetails){
        return "";
    }

    @PostMapping("/loginWithOTP")
    public String loginWithOTP(@RequestBody String mobileNumber){
        return "";
    }

    @PostMapping("/loginWithLinkedIn")
    public String loginWithLinkedIn(@RequestBody SignupDetails signupDetails){
        return "";
    }
}
