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
import hr.vvg.mihajlov.kanfap.model.bean.Predavac;
import hr.vvg.mihajlov.kanfap.model.persistence.PredavacDAO;

@RestController
@RequestMapping("/api")
public class PredavacController {

	@Autowired
	PredavacDAO predavacDAO;
	
	private String[] pozicija = {"PREDAVAC","ASISTENT","DEMONSTRATOR"};
	private List<String> pozicijaList = Arrays.asList(pozicija); 
	
	
	
	// Get All predavac(s)
    @GetMapping("/predavac")
    public List<Predavac> getAllPredavacs() {
        return predavacDAO.findAll(); 
    }

    // Create a new predavac
    @PostMapping("/predavac")
    public Object createPredavac(@Valid @RequestBody Predavac predavac) {
    	
    	if(!pozicijaList.contains(predavac.getPozicija())) {
    		return new Response("error", "pozicija not allowed!");
    	}
        return predavacDAO.save(predavac);
    }

    // Get a Single predavac
    @GetMapping("/predavac/{id}")
    public Predavac getPredavacById(@PathVariable(value = "id") Long predavacId) {
        return predavacDAO.findById(predavacId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavac", "id", predavacId));
    }

    // Update a predavac
    @PutMapping("/predavac/{id}")
    public Object updatePredavac(@PathVariable(value = "id") Long predavacId,
                                            @Valid @RequestBody Predavac predavacDetails) {
    	
    	if(!pozicijaList.contains(predavacDetails.getPozicija())) {
    		return new Response("error", "pozicija not allowed!");
    	}

    	Predavac predavac = predavacDAO.findById(predavacId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavac", "id", predavacId));

    	predavac.setIme(predavacDetails.getIme());
    	predavac.setPozicija(predavacDetails.getPozicija());

        Predavac updatedPredavac = predavacDAO.save(predavac);
        return updatedPredavac;
    }

    
    // Delete a predavac
    @DeleteMapping("/predavac/{id}")
    public ResponseEntity<?> deletePredavac(@PathVariable(value = "id") Long predavacId) {
    	Predavac predavac = predavacDAO.findById(predavacId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavac", "id", predavacId));

    	predavacDAO.delete(predavac);

        return ResponseEntity.ok().build();
    }

}
