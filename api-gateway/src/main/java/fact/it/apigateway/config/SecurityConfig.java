package fact.it.apigateway.config;

import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import static org.springframework.security.config.Customizer.withDefaults;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsConfigurationSource;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity serverHttpSecurity) {
        serverHttpSecurity
                .cors(cors -> cors.configurationSource(corsConfigurationSource())) // Add CORS configuration
                .authorizeExchange(exchange -> exchange
                .pathMatchers(HttpMethod.GET, "/api/device", "/api/house", "api/message").permitAll()
                .pathMatchers(HttpMethod.PUT, "/api/device").permitAll() // Allow DELETE request to /api/device
                .pathMatchers(HttpMethod.DELETE, "/api/device").permitAll() // Allow DELETE request to /api/device
                .anyExchange().authenticated()
                )
                .oauth2ResourceServer(oauth2 -> oauth2
                        .jwt(withDefaults())
                );
        return serverHttpSecurity.build();
    }

    @Bean
    public CorsConfigurationSource corsConfigurationSource() {
        CorsConfiguration corsConfig = new CorsConfiguration();
        corsConfig.setAllowedOrigins(Arrays.asList("http://localhost:4200")); // Allow Angular app
        corsConfig.setAllowedMethods(Arrays.asList("GET", "POST", "PUT", "DELETE", "OPTIONS")); // Allow necessary methods
        corsConfig.setAllowedHeaders(Arrays.asList("Authorization", "Content-Type")); // Allow necessary headers
        corsConfig.setAllowCredentials(true); // Allow credentials if needed

        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        source.registerCorsConfiguration("/**", corsConfig);
        return source;
    }
}
