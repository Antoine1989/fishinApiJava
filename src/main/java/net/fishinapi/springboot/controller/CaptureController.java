package net.fishinapi.springboot.controller;


import java.util.HashMap;

import java.util.List;
import java.util.Map;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
import net.fishinapi.springboot.repository.SpotRepository;

@CrossOrigin(origins = "http://localhost:8082")
@RestController
@RequestMapping("/api/v1/")
public class CaptureController {
	
	@Autowired
	private SpotRepository spotRepository;
	
	@Autowired
	private CaptureRepository captureRepository;

	//get poisson
	@GetMapping("/spots/{spotId}/captures")
	public ResponseEntity<List<Capture>> getAllCapturesBySpotId(@PathVariable(value="spotId") Long spotId) throws ResourceNotFoundException{
		if(!spotRepository.existsById(spotId)) {
			throw new ResourceNotFoundException("Pas de spot correspondant à cet id : " + spotId);
		}
		List <Capture> captures =captureRepository.findBySpotId(spotId);
			return new ResponseEntity<> (captures, HttpStatus.OK);//	captureRepository.findAll();
	}
	
	// get poisson by id	
	@GetMapping("/captures/{id}")
	public ResponseEntity<Capture> getCaptureBySpotId(@PathVariable(value="id") Long id)
	throws ResourceNotFoundException{
		Capture capture = captureRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+id));
				return new ResponseEntity<>(capture, HttpStatus.OK);//ResponseEntity.ok().body(capture);
	}
		
	//save poisson
	//@RequestMapping(value = "/captures",method = RequestMethod.POST,produces = "application/json")
	@PostMapping ("/spots/{spotId}/captures")
	//@ResponseBody
	public ResponseEntity<Capture> createCapture(@PathVariable(value="spotId") Long spotId, @RequestBody Capture captureRequest) throws ResourceNotFoundException{
		Capture capture= spotRepository.findById(spotId).map(spot->{
			captureRequest.setSpot(spot);
			return captureRepository.save(captureRequest);
		}).orElseThrow(()->new ResourceNotFoundException("spot non trouvé"+ spotId));
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
		return  new ResponseEntity<>(capture, HttpStatus.CREATED);//this.captureRepository.save(captureRequest);
		
	}
	//update
	@PutMapping("/captures/{id}")
	public ResponseEntity<Capture> updateCapture(@PathVariable("id") long id, @Valid @RequestBody Capture captureDetails) throws ResourceNotFoundException{
		
		Capture capture = captureRepository.findById(id)
				.orElseThrow(()->new ResourceNotFoundException ("Pas de poisson trouvé à cet id :: "+ id));
		capture.setNomCapture(captureDetails.getNomCapture());
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
	
	/* @DeleteMapping("/spots/{spot_id}/captures")
	  public ResponseEntity<List<Capture>> deleteAllCapturesOfSpot(@PathVariable(value = "spot_id") Long spotId) throws ResourceNotFoundException {
	    if (!spotRepository.existsById(spotId)) {
	      throw new ResourceNotFoundException("Not found spot with id = " + spotId);
	    }

	    captureRepository.deleteBySpotId(spotId);
	    return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	  }*/
}
