package net.fishinapi.springboot.repository;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import net.fishinapi.springboot.model.Capture;

@Repository
public interface CaptureRepository extends JpaRepository<Capture, Long> {

	List<Capture> findAll();
	

}
