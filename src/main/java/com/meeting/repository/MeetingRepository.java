package com.meeting.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.meeting.model.Meeting;
import com.meeting.model.User;

public interface MeetingRepository extends JpaRepository<Meeting, Integer> {

	@Modifying
	@Transactional
	@Query(value="insert into meeting_task values (:mid,:tid)", nativeQuery=true)
	void assignTask(@Param("mid")int mid,@Param("tid") int tid);

	@Modifying
	@Transactional
	@Query(value="select * from meeting where user_id=:uid", nativeQuery=true)
	List<Meeting> getAllMeetingsbyUserId(@Param("uid")int uid);
}
