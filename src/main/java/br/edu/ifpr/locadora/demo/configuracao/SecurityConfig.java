package br.edu.ifpr.locadora.demo.configuracao;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
            .authorizeHttpRequests(requests -> requests
                .anyRequest().authenticated() // Exige autenticação para QUALQUER requisição
            )
            .formLogin(form -> form
                .loginPage("/login") // Diz ao Spring para usar uma página de login customizada (que criaremos)
                .permitAll() // Permite que todos acessem a página de login
            )
            .logout(logout -> logout.permitAll()); // Permite que todos façam logout

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // Cria um usuário em memória com login "user" e senha "password"
        UserDetails user = User.builder()
            .username("user")
            .password(passwordEncoder().encode("password")) // A senha DEVE ser codificada
            .roles("USER")
            .build();

        return new InMemoryUserDetailsManager(user);
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        // Define o codificador de senhas que será usado
        return new BCryptPasswordEncoder();
    }
}