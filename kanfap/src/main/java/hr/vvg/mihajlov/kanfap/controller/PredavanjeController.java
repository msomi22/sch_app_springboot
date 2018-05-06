package hr.vvg.mihajlov.kanfap.controller;

import java.util.Arrays;
import java.util.List;

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

import hr.vvg.mihajlov.kanfap.exception.ResourceNotFoundException;
import hr.vvg.mihajlov.kanfap.model.bean.Predavanje;
import hr.vvg.mihajlov.kanfap.model.persistence.PredavanjeDAO;


@RestController
@RequestMapping("/api")
public class PredavanjeController {

	@Autowired
    PredavanjeDAO predavanjeDAO;
	
	private String[] vrste = {"PREZENTACIJA","PRIMJER","VJEZBA"};
	private List<String> vrsteList = Arrays.asList(vrste); 

	
	
	// Get All predavanje(s)
    @GetMapping("/predavanje")
    public List<Predavanje> getAllPredavanjes() {
        return predavanjeDAO.findAll(); 
    }

    // Create a new predavanje
    @PostMapping("/predavanje")
    public Object createPredavanje(@Valid @RequestBody Predavanje predavanje) {
    	if(!vrsteList.contains(predavanje.getVrsta())) { 
    		return new Response("error", "pozicija not allowed!");
    	}
        return predavanjeDAO.save(predavanje);
    }

    // Get a Single predavanje
    @GetMapping("/predavanje/{id}")
    public Predavanje getPredavanjeById(@PathVariable(value = "id") Long predavanjeId) {
        return predavanjeDAO.findById(predavanjeId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavanje", "id", predavanjeId));
    }

    // Update a predavanje
    @PutMapping("/predavanje/{id}")
    public Object updatePredavanje(@PathVariable(value = "id") Long predavanjeId,
                                            @Valid @RequestBody Predavanje predavanjeDetails) {
    	
    	if(!vrsteList.contains(predavanjeDetails.getVrsta())) { 
    		return new Response("error", "pozicija not allowed!");
    	}

    	Predavanje predavanje = predavanjeDAO.findById(predavanjeId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavanje", "id", predavanjeId));

    	predavanje.setTema(predavanjeDetails.getTema());
    	predavanje.setSadrzaj(predavanjeDetails.getSadrzaj());
    	predavanje.setVrsta(predavanjeDetails.getVrsta());
    	predavanje.setObjavljeno(predavanjeDetails.isObjavljeno()); 

    	Predavanje updatedPredavanje = predavanjeDAO.save(predavanje);
        return updatedPredavanje;
    }

    
    // Delete a predavanje
    @DeleteMapping("/predavanje/{id}")
    public ResponseEntity<?> deletePredavanje(@PathVariable(value = "id") Long predavanjeId) {
    	Predavanje predavanje = predavanjeDAO.findById(predavanjeId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavanje", "id", predavanjeId));

    	predavanjeDAO.delete(predavanje);

        return ResponseEntity.ok().build();
    }

}
