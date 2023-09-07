import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class TestSecurityConfig extends WebSecurityConfigurerAdapter {

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/secured-endpoint").authenticated() // Secure this endpoint
                .anyRequest().permitAll() // Allow all other requests
                .and()
                .httpBasic(); // Use basic authentication for testing
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        // Configure an in-memory user for testing
        auth
                .inMemoryAuthentication()
                .withUser("testuser").password("{noop}testpassword").roles("USER");
    }
}
