package net.fishinapi.springboot.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.fishinapi.springboot.exception.ResourceNotFoundException;
import net.fishinapi.springboot.model.Capture;
import net.fishinapi.springboot.repository.CaptureRepository;

@RestController
@RequestMapping("/api/v1/")
public class CaptureController {
	
	private CaptureRepository captureRepository;

	//get poisson
	@GetMapping("capture")
	public List<Capture> getAllCaptures(){
		return this.captureRepository.findAll();
	}
	
	// get poisson by id	
	@GetMapping("/captures/{id_capture}")
	public ResponseEntity<Capture> getCaptureById(@PathVariable(value="id_capture") Long captureId)
	throws ResourceNotFoundException{
		Capture capture = captureRepository.findById(captureId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+captureId));
				return ResponseEntity.ok().body(capture);
	}
		
	//save poisson
	@PostMapping ("capture")
	public Capture createCapture(@RequestBody Capture capture) {
		return this.captureRepository.save(capture);
		
	}
	//update
	@PutMapping("captures/{id_capture}")
	public ResponseEntity<Capture> updateCapture(@PathVariable(value="id_capture") Long captureId, /*@Valid*/ @RequestBody Capture captureDetails) throws ResourceNotFoundException{
		
		Capture capture = captureRepository.findById(captureId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+captureId));
		capture.setNom(captureDetails.getNom());
		capture.setTechnique(captureDetails.getTechnique());
		capture.setQuantite(captureDetails.getQuantite());
		capture.setPoids(captureDetails.getPoids());
		capture.setLongueur(captureDetails.getLongueur());
		capture.setDate_peche(captureDetails.getDate_peche());
		capture.setMaree(captureDetails.getMaree());
		capture.setCoef(captureDetails.getCoef());
		capture.setCommentaires(captureDetails.getCommentaires());
		capture.setPhoto(captureDetails.getPhoto());
		return ResponseEntity.ok(this.captureRepository.save(capture));
	}
	//delete
	@DeleteMapping("captures/{id_capture}")
	public Map<String,Boolean> deletePoisson(@PathVariable(value="id_capture") Long captureId) throws ResourceNotFoundException{
		Capture capture = captureRepository.findById(captureId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+captureId));
		this.captureRepository.delete(capture);
		
		 Map<String,Boolean> response =new HashMap<>();
		 response.put("Supprimé", Boolean.TRUE);
		 
		 return response;
	}
}
