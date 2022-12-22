package net.fishinapi.springboot.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fishinapi.springboot.model.Spot;

@Repository
public interface SpotRepository extends JpaRepository<Spot, Long> {
	List<Spot> findAll();
}
