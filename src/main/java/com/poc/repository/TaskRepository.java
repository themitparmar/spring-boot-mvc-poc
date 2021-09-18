package com.poc.repository;

import com.poc.model.Task;
import com.poc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mitesh Parmar
 */
public interface TaskRepository extends JpaRepository<Task, Long> {
}
