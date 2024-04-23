package nocountry.beathub;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BeathubApplication {

	public static void main(String[] args) {


		System.out.println("Mensaje de prueba por consola.");
		SpringApplication.run(BeathubApplication.class, args);
	}

}
