package io.schultz.dustin.weatherservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

import java.util.concurrent.ThreadLocalRandom;

@SpringBootApplication
@RestController
@EnableDiscoveryClient
public class WeatherServiceApplication {

    private String[] weather = new String[] {"sunny", "cloudy", "windy", "rainy"};

	public static void main(String[] args) {
		SpringApplication.run(WeatherServiceApplication.class, args);
	}

	@GetMapping("/weather")
    public String getWeather() {
	    int random = ThreadLocalRandom.current().nextInt(0, 4);
	    return weather[random];
    }
}
