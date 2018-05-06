package hr.vvg.mihajlov.kanfap.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import hr.vvg.mihajlov.kanfap.exception.ResourceNotFoundException;
import hr.vvg.mihajlov.kanfap.model.bean.Korisnik;
import hr.vvg.mihajlov.kanfap.model.persistence.KorisnikDAO;

@RestController
@RequestMapping("/api")
public class KorisnikController {
	
	@Autowired
	KorisnikDAO korisnikDAO;
	
	
	// this is the LoginController
	@RequestMapping(value={"/", "/login"}, method = RequestMethod.GET)
	public ModelAndView login(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("login");
		return modelAndView;
	}
	
	// this is the user reg Controller 
	@RequestMapping(value = "/registration", method = RequestMethod.POST)
	public ModelAndView createNewUser(@Valid  Korisnik korisnik, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		Korisnik userExists = korisnikDAO.findUserByUsername(korisnik.getUsername());
		if (userExists != null) {
			bindingResult
					.rejectValue("username", "error.korisnik",
							"There is already a user registered with the username provided");
		}
		if (bindingResult.hasErrors()) {
			modelAndView.setViewName("registration");
		} else {
			korisnikDAO.save(korisnik); 
			modelAndView.addObject("successMessage", "User has been registered successfully");
			modelAndView.addObject("user", new Korisnik()); 
			modelAndView.setViewName("registration");
			
		}
		return modelAndView;
	}

	
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
