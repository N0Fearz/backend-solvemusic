package src.main.java.com.example.fileservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("src.main.java.com.example.fileservice.repository")
@Configuration
public class FileService {

    public static void main(String[] args) {
        SpringApplication.run(FileService.class, args);
    }

}
