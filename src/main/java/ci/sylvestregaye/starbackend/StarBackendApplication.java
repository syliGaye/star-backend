package ci.sylvestregaye.starbackend;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@EnableScheduling
@SpringBootApplication
public class StarBackendApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(StarBackendApplication.class, args);
    }

    @Bean
    public CommandLineRunner init() {
        return args -> {
            final String sDate = "20240408";

            // Format du string date
            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

            try {
                // Conversion du string en date
                Date date = sdf.parse(sDate);
                System.out.println("Date: " + date);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        };
    }
}
