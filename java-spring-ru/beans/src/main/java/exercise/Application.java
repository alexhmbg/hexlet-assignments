package exercise;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.LocalDateTime;

import exercise.daytime.Daytime;
import exercise.daytime.Day;
import exercise.daytime.Night;

// BEGIN
import org.springframework.context.annotation.Bean;
import org.springframework.web.context.annotation.RequestScope;
// END

@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    // BEGIN
    @Bean
    @RequestScope
    public Daytime getDayTime() {
        int hour = LocalDateTime.now().getHour();
        var dayName = new Day();
        var nightName = new Night();
        var dayOrNight = (hour >= 6 && hour <= 22) ? dayName : nightName;
        return dayOrNight;
    }
    // END
}
