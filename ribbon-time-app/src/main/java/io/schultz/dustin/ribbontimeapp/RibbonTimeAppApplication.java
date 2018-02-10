package io.schultz.dustin.ribbontimeapp;

import io.schultz.dustin.configuration.RibbonTimeConfiguration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RestController
@RibbonClient(name = "time-service", configuration = RibbonTimeConfiguration.class)
@Configuration
@ComponentScan("io.schultz.dustin.ribbontimeapp")
public class RibbonTimeAppApplication {

    @Autowired
    private RestTemplate restTemplate;

	public static void main(String[] args) {
		SpringApplication.run(RibbonTimeAppApplication.class, args);
	}

	@GetMapping
	public String getCurrentTime() {
	    return restTemplate.getForEntity("http://time-service", String.class).getBody();
    }

	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
	    return new RestTemplate();
    }
}
