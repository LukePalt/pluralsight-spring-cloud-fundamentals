package io.schultz.dustin.configuration;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RibbonTimeConfiguration {

    @Bean
    public IRule ribbonRule() {
        return new RandomRule();
    }
}
