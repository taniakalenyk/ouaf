package academy.ouaf;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class OuafApplication {

	public static void main(String[] args) {
		SpringApplication.run(OuafApplication.class, args);
	}

	// This annotation marks the method to be executed after the bean is initialized, making it useful for setting up any additional configuration or initialization logic.
	@PostConstruct
	public void init() {
		TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
	}
}
