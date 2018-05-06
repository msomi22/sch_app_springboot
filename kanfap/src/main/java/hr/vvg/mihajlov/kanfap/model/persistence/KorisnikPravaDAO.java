/**
 * 
 */
package hr.vvg.mihajlov.kanfap.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.vvg.mihajlov.kanfap.model.bean.KorisnikPrava;


@Repository 
public interface KorisnikPravaDAO extends JpaRepository<KorisnikPrava, Long> {

}
