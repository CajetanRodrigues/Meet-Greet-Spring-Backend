package com.meeting.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meeting.model.Meeting;
import com.meeting.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{
	
	@Transactional
	@Query(value="select * from user where email=:email", nativeQuery=true)
	User getIdFromEmail(@Param("email") String email);
}
