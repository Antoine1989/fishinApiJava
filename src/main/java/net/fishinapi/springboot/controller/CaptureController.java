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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import net.fishinapi.springboot.exception.ResourceNotFoundException;
import net.fishinapi.springboot.model.Capture;
import net.fishinapi.springboot.model.TypeCapture;
import net.fishinapi.springboot.repository.CaptureRepository;

@RestController
@RequestMapping("/api/v1/")
public class CaptureController {
	
	@Autowired
	private CaptureRepository captureRepository;

	//get poisson
	@GetMapping("/captures")
	public List<Capture> getAllCaptures(){
		return captureRepository.findAll();
	}
	
	// get poisson by id	
	@GetMapping(path="/captures/{capture_id}", produces={"application/json", "application/xml"})
	public ResponseEntity<Capture> getCaptureById(@PathVariable(value="capture_id") Long captureId)
	throws ResourceNotFoundException{
		Capture capture = captureRepository.findById(captureId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+captureId));
				return ResponseEntity.ok().body(capture);
	}
		
	//save poisson
	//@RequestMapping(value = "/captures",method = RequestMethod.POST,produces = "application/json")
	@PostMapping (path="/captures", produces={"application/json", "application/xml"})
	//@ResponseBody
	public Capture createCapture(@RequestBody Capture capture) throws ResourceNotFoundException{
		String poisson=  TypeCapture.POISSON.toString();
		String cephalopode=  TypeCapture.CEPHALOPODE.toString();
		String crustace=  TypeCapture.CRUSTACE.toString();
		if(capture.getType()!=poisson){
			throw new ResourceNotFoundException ("La capture doit être de type 'POISSON','CRUSTACE' ou 'CEPHALOPODE'");
		}
		else if(capture.getType()!=crustace) {
			throw new ResourceNotFoundException ("La capture doit être de type 'POISSON','CRUSTACE' ou 'CEPHALOPODE'");
		}
		else if(capture.getType()!=cephalopode) {
			throw new ResourceNotFoundException ("La capture doit être de type 'POISSON','CRUSTACE' ou 'CEPHALOPODE'");
		}
		else 
		return this.captureRepository.save(capture);
		
	}
	//update
	@PutMapping("/captures/{capture_id}")
	public ResponseEntity<Capture> updateCapture(@PathVariable(value="capture_id") Long captureId, @Valid @RequestBody Capture captureDetails) throws ResourceNotFoundException{
		
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
	@DeleteMapping("/captures/{capture_id}")
	public Map<String,Boolean> deletePoisson(@PathVariable(value="capture_id") Long captureId) throws ResourceNotFoundException{
		Capture capture = captureRepository.findById(captureId)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+captureId));
		this.captureRepository.delete(capture);
		
		 Map<String,Boolean> response =new HashMap<>();
		 response.put("Supprimé", Boolean.TRUE);
		 
		 return response;
	}
}
