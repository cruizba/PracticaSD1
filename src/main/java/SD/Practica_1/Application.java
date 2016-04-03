package SD.Practica_1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

	public static String ROOT = "src/main/resources/static/img/especies";

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
