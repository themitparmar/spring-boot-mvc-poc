package com.poc.repository;

import com.poc.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Mitesh Parmar
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByUsername(String username);

}
