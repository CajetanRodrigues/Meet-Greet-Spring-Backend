package com.meeting.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meeting.model.EmailOtp;


public interface EmailOtpRepository  extends JpaRepository<EmailOtp, String>{
	
	@Transactional
	@Query(value="select * from email_otp where email=:emailData AND otp=:otpData", nativeQuery=true)
	EmailOtp checkEmailOtp(@Param("emailData")String emailData,@Param("otpData") String otpData);
}
