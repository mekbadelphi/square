package square.auth.square;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

import static square.auth.square.Quickstart.getAccessToken;

@SpringBootApplication
public class SquareApplication extends SpringBootServletInitializer {

    public static void main(String[] args) {
        SpringApplication.run(SquareApplication.class, args);
//        Quickstart.getAccessToken();
    }

}
