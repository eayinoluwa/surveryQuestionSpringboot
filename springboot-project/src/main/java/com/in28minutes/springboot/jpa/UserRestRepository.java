package com.in28minutes.springboot.jpa;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Component;

@Component
public interface UserRestRepository extends CrudRepository<User, Long> {
	List<User> findByRole(@Param("role") String role);
}
