package de.maeddes.simplecode;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class SimplecodeApplication {

	@Value("${HOSTNAME:not_set}")
	String hostname;

	@Value("${spring.profiles.active: none}")
	String profile;

	org.slf4j.Logger logger = LoggerFactory.getLogger(SimplecodeApplication.class);

	private String getInstanceId(){

		if(!hostname.equals("not_set")) return hostname;
		return "probably not set";

	}

	@GetMapping("/")
	String helloABC(){

		logger.info("Call to helloABC method on instance: " + getInstanceId());
		return getInstanceId()+" Hello, Container people ! ";

	}

	@GetMapping("/new")
	String newEndpoint(){

		logger.info("Call to new method on instance: " + getInstanceId());
		return " Hello, World ! ";

	}

	@GetMapping("/fail")
	String fail() {

		logger.info("Call to failing method on instance: "+getInstanceId());
		System.exit(1);
		return "fixed!";
	}

	public static void main(final String[] args) {
		SpringApplication.run(SimplecodeApplication.class, args);
	}

}
