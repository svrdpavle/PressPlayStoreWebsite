package com.example.press_play_store_website;

import com.example.press_play_store_website.entities.UserEntity;
import com.example.press_play_store_website.repositories.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PressPlayStoreWebsiteApplication {

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public static void main(String[] args) {
        SpringApplication.run(PressPlayStoreWebsiteApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner demo(UserRepository userRepository) {
//        return args -> {
//            userRepository.save(new UserEntity("pavle", encoder.encode("pavle"), "ADMIN", 1));
//            userRepository.save(new UserEntity("bob", encoder.encode("bob"), "USER", 1));
//        };
//    }
}
