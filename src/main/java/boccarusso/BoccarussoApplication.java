package boccarusso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BoccarussoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BoccarussoApplication.class, args);
	}

	@Bean
	public static String sanitize(String s) {
		return s
				.replaceAll(" ", "-")
				.replaceAll("&", "and");
	}

}
