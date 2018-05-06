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
import hr.vvg.mihajlov.kanfap.model.bean.Korisnik;
import hr.vvg.mihajlov.kanfap.model.persistence.KorisnikDAO;

@RestController
@RequestMapping("/api")
public class KorisnikController {
	
	@Autowired
	KorisnikDAO korisnikDAO;

	
	// Get All korisnik(s)
    @GetMapping("/korisnik")
    public List<Korisnik> getAllKorisniks() {
        return  (List<Korisnik>) korisnikDAO.findAll();  //(List<Korisnik>)
    }

    // Create a new korisnik
    @PostMapping("/korisnik")
    public Korisnik createKorisnik(@Valid @RequestBody Korisnik korisnik) {
        return korisnikDAO.save(korisnik);
    }

    // Get a Single Korisnik
    @GetMapping("/korisnik/{id}")
    public Korisnik getKorisnikById(@PathVariable(value = "id") Long korisnikId) {
        return korisnikDAO.findById(korisnikId)
                .orElseThrow(() -> new ResourceNotFoundException("Korisnik", "id", korisnikId));
    }

    // Update a Korisnik
    @PutMapping("/korisnik/{id}")
    public Korisnik updateKorisnik(@PathVariable(value = "id") Long korisnikId,
                                            @Valid @RequestBody Korisnik korisnikDetails) {

    	Korisnik korisnik = korisnikDAO.findById(korisnikId)
                .orElseThrow(() -> new ResourceNotFoundException("Korisnik", "id", korisnikId));

    	korisnik.setUsername(korisnikDetails.getUsername());
    	korisnik.setPassword(korisnikDetails.getPassword());
    	korisnik.setEnabled(korisnikDetails.isEnabled());

    	Korisnik updatedKorisnik = korisnikDAO.save(korisnik);
        
        return updatedKorisnik;
    }

    
    // Delete a Korisnik
    @DeleteMapping("/korisnik/{id}")
    public ResponseEntity<?> deleteKorisnik(@PathVariable(value = "id") Long korisnikId) {
    	Korisnik korisnik = korisnikDAO.findById(korisnikId)
                .orElseThrow(() -> new ResourceNotFoundException("Korisnik", "id", korisnikId));

    	korisnikDAO.delete(korisnik);

        return ResponseEntity.ok().build();
    }
	
	

}
