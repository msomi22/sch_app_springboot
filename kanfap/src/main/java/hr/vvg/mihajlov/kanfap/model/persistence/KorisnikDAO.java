package hr.vvg.mihajlov.kanfap.model.persistence;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import hr.vvg.mihajlov.kanfap.model.bean.Korisnik;

@Repository 
public interface KorisnikDAO extends CrudRepository<Korisnik, Long> {

	public Korisnik findUserByUsername(String username); 
	
}
