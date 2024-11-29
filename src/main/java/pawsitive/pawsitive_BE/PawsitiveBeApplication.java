package pawsitive.pawsitive_BE;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class PawsitiveBeApplication {

	public static void main(String[] args) {
		SpringApplication.run(PawsitiveBeApplication.class, args);
	}

}
