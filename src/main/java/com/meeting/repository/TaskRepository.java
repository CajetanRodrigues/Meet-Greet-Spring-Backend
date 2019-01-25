package com.meeting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.meeting.model.Meeting;
import com.meeting.model.Task;

public interface TaskRepository extends JpaRepository<Task, Integer>{
List<Task> findAllByMeetingId(int id);
}
