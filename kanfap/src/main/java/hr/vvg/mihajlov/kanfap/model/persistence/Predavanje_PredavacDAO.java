package hr.vvg.mihajlov.kanfap.model.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import hr.vvg.mihajlov.kanfap.model.bean.Predavanje_Predavac;

@Repository 
public interface Predavanje_PredavacDAO extends JpaRepository<Predavanje_Predavac, Long> {


}
