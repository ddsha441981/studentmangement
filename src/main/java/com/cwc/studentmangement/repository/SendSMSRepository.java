package com.cwc.studentmangement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cwc.studentmangement.model.SendSMS;

@Repository
public interface SendSMSRepository  extends JpaRepository<SendSMS, Integer>{

}
