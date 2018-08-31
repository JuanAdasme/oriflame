package cl.oriflame;

import java.util.Optional;
import java.util.Properties;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OriflameApplication {
	
	//Get PORT and HOST from Environment or set default
	public static final Optional<String> HOST;
	public static final Optional<String> PORT;
	public static final Properties PROPS = new Properties();
	
	static {
		HOST = Optional.ofNullable(System.getenv("HOSTNAME"));
		PORT = Optional.ofNullable(System.getenv("PORT"));
	}

	public static void main(String[] args) {
		//Set properties
		PROPS.setProperty("server.addres", HOST.orElse("localhost"));
		PROPS.setProperty("server.port", PORT.orElse("8080"));
		
		SpringApplication app = new SpringApplication(OriflameApplication.class);
		app.setDefaultProperties(PROPS);
		app.run(args);
	}
}
