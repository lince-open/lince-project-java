package work.lince.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

@SpringBootApplication(scanBasePackages = "work.lince")
@ServletComponentScan("work.lince")
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
