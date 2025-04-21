
package com.example.emailapp;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EmailAppApplication {

    public static void main(String[] args) {
        // Load environment variables from .env file
        Dotenv dotenv = Dotenv.configure()
                .ignoreIfMissing()
                .load();

        // Just for debugging (optional)
        System.out.println("Loaded DB URL: " + dotenv.get("MYSQL_URL"));

        SpringApplication.run(EmailAppApplication.class, args);
    }
}
