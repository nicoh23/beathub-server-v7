package nocountry.beathub.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableWebMvc
public class CorsConfig implements WebMvcConfigurer {

    @Override
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS")
                .allowedOrigins("http://localhost:3000", "https://beat-hub-app.vercel.app", "https://beat-hub-app-git-main-leotheprodus-projects.vercel.app")
                .allowedHeaders("*")
                .allowCredentials(true)
                .exposedHeaders("abc")
                .maxAge(36L);
    }
}