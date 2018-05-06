
package hr.vvg.mihajlov.kanfap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
// mvn spring-boot:run
public class Application {
	
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
    
}
