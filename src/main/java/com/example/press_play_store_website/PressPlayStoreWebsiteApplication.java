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
//            userRepository.save(new UserEntity(1, "pavle", "svrdlin",
//                    "pavemail", encoder.encode("pavle"), "store address",
//                    "ADMIN", 1));
//            userRepository.save(new UserEntity(2, "bob", "bobby",
//                    "bobemail", encoder.encode("bob"), "store address",
//                    "CUSTOMER", 1));
//        };
//    }
}
