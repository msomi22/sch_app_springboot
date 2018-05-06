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
import hr.vvg.mihajlov.kanfap.model.bean.KorisnikPrava;
import hr.vvg.mihajlov.kanfap.model.persistence.KorisnikPravaDAO;

@RestController
@RequestMapping("/api")
public class KorisnikPravaController {

	@Autowired
	KorisnikPravaDAO korisnikPravaDAO;

	
	
	// Get All korisnikPrava(s)
    @GetMapping("/korisnikPrava")
    public List<KorisnikPrava> getAllKorisnikPravas() {
        return korisnikPravaDAO.findAll(); 
    }

    // Create a new korisnikPrava
    @PostMapping("/korisnikPrava")
    public KorisnikPrava createKorisnikPrava(@Valid @RequestBody KorisnikPrava korisnikPrava) {
        return korisnikPravaDAO.save(korisnikPrava);
    }

    // Get a Single korisnikPrava
    @GetMapping("/korisnikPrava/{id}")
    public KorisnikPrava getKorisnikPravaById(@PathVariable(value = "id") Long korisnikPravaId) {
        return korisnikPravaDAO.findById(korisnikPravaId)
                .orElseThrow(() -> new ResourceNotFoundException("KorisnikPrava", "id", korisnikPravaId));
    }

    // Update a korisnikPrava
    @PutMapping("/korisnikPrava/{id}")
    public KorisnikPrava updateKorisnikPrava(@PathVariable(value = "id") Long korisnikPravaId,
                                            @Valid @RequestBody KorisnikPrava korisnikPravaDetails) {

    	KorisnikPrava korisnikPrava = korisnikPravaDAO.findById(korisnikPravaId)
                .orElseThrow(() -> new ResourceNotFoundException("KorisnikPrava", "id", korisnikPravaId));

    	korisnikPrava.setUsername(korisnikPravaDetails.getUsername());
    	korisnikPrava.setAuthority(korisnikPravaDetails.getAuthority());

    	KorisnikPrava updatedKorisnikPrava = korisnikPravaDAO.save(korisnikPrava);
        return updatedKorisnikPrava;
    }

    
    // Delete a korisnikPrava
    @DeleteMapping("/korisnikPrava/{id}")
    public ResponseEntity<?> deleteKorisnikPrava(@PathVariable(value = "id") Long korisnikPravaId) {
    	KorisnikPrava korisnikPrava = korisnikPravaDAO.findById(korisnikPravaId)
                .orElseThrow(() -> new ResourceNotFoundException("KorisnikPrava", "id", korisnikPravaId));

    	korisnikPravaDAO.delete(korisnikPrava);

        return ResponseEntity.ok().build();
    }
}
