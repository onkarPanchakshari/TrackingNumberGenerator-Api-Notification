package io.github.onkarp.generator_api_notification;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GeneratorApiNotificationApplication {

	public static void main(String[] args) {
        Dotenv dotenv = Dotenv.load();  // Load .env file
        System.setProperty("MAIL_USERNAME", dotenv.get("MAIL_USERNAME"));
        System.setProperty("MAIL_PASSWORD", dotenv.get("MAIL_PASSWORD"));
        SpringApplication.run(GeneratorApiNotificationApplication.class, args);
	}

}
