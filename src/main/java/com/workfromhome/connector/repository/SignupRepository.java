package com.workfromhome.connector.repository;

import com.workfromhome.connector.model.SignupDetails;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface SignupRepository extends MongoRepository<SignupDetails, String> {
    @Query("{mobileNumber : ?0}")
    List<SignupDetails> findByMobileNumber(String mobileNumber);
    @Query("{emailId : ?0}")
    List<SignupDetails> findByEmailId(String emailId);
}