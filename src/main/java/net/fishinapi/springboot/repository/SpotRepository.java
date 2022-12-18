package net.fishinapi.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import net.fishinapi.springboot.model.Spot;

public interface SpotRepository extends JpaRepository<Spot, Long> {
	List<Spot> findAll();
}
