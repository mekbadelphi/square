package square.auth.square;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import static square.auth.square.Quickstart.getAccessToken;

@SpringBootApplication
public class SquareApplication {

    public static void main(String[] args) {

        SpringApplication.run(SquareApplication.class, args);
        Quickstart.getAccessToken();
    }

}
