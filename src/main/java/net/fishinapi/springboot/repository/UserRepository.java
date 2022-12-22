package net.fishinapi.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fishinapi.springboot.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
	List<User> findAll();

}
