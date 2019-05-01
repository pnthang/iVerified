package ca.gtem;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.Ordered;
import org.springframework.http.CacheControl;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;

import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.TimeUnit;


@SpringBootApplication
@ComponentScan("ca.gtem")
public class Application {
		
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        // Register resource handler for images
        registry.addResourceHandler("/images/**").addResourceLocations("classpath:/resources/public/images/")
                .setCacheControl(CacheControl.maxAge(2, TimeUnit.HOURS).cachePublic());
    }
	
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }        
    
    
 // Fix the CORS errors
    //@Bean
    //public FilterRegistrationBean simpleCorsFilter() {  
     //   UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();  
     //   CorsConfiguration config = new CorsConfiguration();  
     //   config.setAllowedOrigins(Arrays.asList("*"));
     //   config.setAllowCredentials(true);
     //   config.setAllowedHeaders(Arrays.asList("Access- Control-Allow-Headers","Access-Control-Allow-Origin","Access-Control-Request-Method", "Access-Control-Request-Headers","Origin","Cache-Control", "Content-Type", "Authorization"));
     //   config.setAllowedMethods(Arrays.asList("DELETE", "GET", "POST", "PATCH", "PUT"));                       
        // *** URL below needs to match the client URL and port ***
        //config.setAllowedOrigins(Collections.singletonList("*")); 
        //config.setAllowedMethods(Collections.singletonList("*"));  
        //config.setAllowedHeaders(Collections.singletonList("*"));  
     //   source.registerCorsConfiguration("/**", config);  
     //   FilterRegistrationBean bean = new FilterRegistrationBean(new CorsFilter(source));
     //   bean.setOrder(Ordered.HIGHEST_PRECEDENCE);  
     //   return bean;  
    //} 
}
