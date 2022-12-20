package net.fishinapi.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import net.fishinapi.springboot.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();

}
