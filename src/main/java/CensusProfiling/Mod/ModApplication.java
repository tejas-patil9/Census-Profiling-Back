package CensusProfiling.Mod;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ModApplication {

	public static void main(String[] args) {
		System.out.println("Start");
		SpringApplication.run(ModApplication.class, args);
		System.out.println("end");
	}

}
