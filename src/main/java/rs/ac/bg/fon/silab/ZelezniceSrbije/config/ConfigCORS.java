package rs.ac.bg.fon.silab.ZelezniceSrbije.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class ConfigCORS implements WebMvcConfigurer {
	
	@Override
	public void addCorsMappings(CorsRegistry registry) {

		registry.addMapping("/**").allowedOrigins("*").allowedMethods("POST", "PUT", "GET", "DELETE", "OPTIONS")
				.allowedHeaders("Content-Type", "Origin")
				.exposedHeaders("X-Total-Count", "Location", "Access-Control-Allow-Origin").allowCredentials(false)
				.maxAge(6000);
	}
}
