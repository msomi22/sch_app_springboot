package hr.vvg.mihajlov.kanfap.controller;

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
import hr.vvg.mihajlov.kanfap.model.bean.Predavanje_Predavac;
import hr.vvg.mihajlov.kanfap.model.persistence.Predavanje_PredavacDAO;

@RestController
@RequestMapping("/api")
public class PredavanjePredavaController {

	@Autowired
	Predavanje_PredavacDAO predavanje_PredavacDAO;

	
	// Get All predavanjePredava(s)
    @GetMapping("/predavanjePredava")
    public List<Predavanje_Predavac> getAllPredavanje_Predavacs() {
        return predavanje_PredavacDAO.findAll(); 
    }

    // Create a new predavanjePredava
    @PostMapping("/predavanjePredava")
    public Predavanje_Predavac createPredavanje_Predavac(@Valid @RequestBody Predavanje_Predavac pp) {
        return predavanje_PredavacDAO.save(pp);
    }

    // Get a Single predavanjePredava
    @GetMapping("/predavanjePredava/{id}")
    public Predavanje_Predavac getPredavanje_PredavacById(@PathVariable(value = "id") Long ppId) {
        return predavanje_PredavacDAO.findById(ppId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavanje_Predavac", "id", ppId));
    }

    // Update a predavanjePredava
    @PutMapping("/predavanjePredava/{id}")
    public Predavanje_Predavac updatePredavanje_Predavac(@PathVariable(value = "id") Long ppId,
                                            @Valid @RequestBody Predavanje_Predavac ppDetails) {

    	Predavanje_Predavac predavanje_Predavac = predavanje_PredavacDAO.findById(ppId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavanje_Predavac", "id", ppId));

    	predavanje_Predavac.setPredavanje(ppDetails.getPredavanje());
    	predavanje_Predavac.setPredavac(ppDetails.getPredavac()); 

    	Predavanje_Predavac updatedPP = predavanje_PredavacDAO.save(predavanje_Predavac);
        return updatedPP;
    }

    
    // Delete a predavanjePredava
    @DeleteMapping("/predavanjePredava/{id}")
    public ResponseEntity<?> deletePredavanje_Predavac(@PathVariable(value = "id") Long ppId) {
    	Predavanje_Predavac pp = predavanje_PredavacDAO.findById(ppId)
                .orElseThrow(() -> new ResourceNotFoundException("Predavanje_Predavac", "id", ppId));

    	predavanje_PredavacDAO.delete(pp);

        return ResponseEntity.ok().build();
    }

}
