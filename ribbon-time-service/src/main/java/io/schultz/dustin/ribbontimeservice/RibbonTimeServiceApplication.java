package io.schultz.dustin.ribbontimeservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalTime;

@SpringBootApplication
@RestController
public class RibbonTimeServiceApplication {

    @Value("${server.port}")
    private int port;

	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeServiceApplication.class, args);
	}

	@GetMapping
    public String getCurrentTime() {
	    return LocalTime.now().toString() + "(Service running on port " + port + ")";
    }
}
