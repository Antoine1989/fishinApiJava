package net.fishinapi.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import net.fishinapi.springboot.exception.ResourceNotFoundException;
import net.fishinapi.springboot.model.Spot;
import net.fishinapi.springboot.repository.SpotRepository;

@RestController
@RequestMapping("/api/v1/")
public class SpotController {

	@Autowired
	private SpotRepository spotRepository;

	//get spot
	@GetMapping("/spots")
	public List<Spot> getAllSpot(){
		return spotRepository.findAll();
	}
	
	// get spot by id	
	@GetMapping("/spots/{spot_id}")
	public ResponseEntity<Spot> getSpotById(@PathVariable(value="spot_id") Long spotId)
	throws ResourceNotFoundException{
		Spot spot = spotRepository.findById(spotId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+spotId));
				return ResponseEntity.ok().body(spot);
	}
		
	//save spot
	@RequestMapping(value = "/spots",method = RequestMethod.POST,produces = "application/json")
	//@PostMapping ("/spots")
	//@ResponseBody
	public Spot createSpot(@RequestBody Spot spot) {
		
		return this.spotRepository.save(spot);
		
	}
	//update
	@PutMapping("/spots/{spot_id}")
	public ResponseEntity<Spot> updateSpot(@PathVariable(value="spot_id") Long spotId, @Valid @RequestBody Spot spotDetails) throws ResourceNotFoundException{
		
		Spot spot = spotRepository.findById(spotId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de spot trouvé à cet id :: "+spotId));
		spot.setNom(spotDetails.getNom());
		spot.setVille(spotDetails.getVille());
		
		return ResponseEntity.ok(this.spotRepository.save(spot));
	}
	//delete
	@DeleteMapping("/spots/{spot_id}")
	public Map<String,Boolean> deleteSpot(@PathVariable(value="spot_id") Long spotId) throws ResourceNotFoundException{
		Spot spot = spotRepository.findById(spotId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+spotId));
		this.spotRepository.delete(spot);
		
		 Map<String,Boolean> response =new HashMap<>();
		 response.put("Supprimé", Boolean.TRUE);
		 
		 return response;
	}
}
