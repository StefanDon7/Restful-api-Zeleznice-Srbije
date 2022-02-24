package rs.ac.bg.fon.silab.ZelezniceSrbije.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigCORS implements WebMvcConfigurer {

    public ConfigCORS() {
        System.out.println("ConfigCORS created.");
    }

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**").allowedOrigins("*");
    }
}
