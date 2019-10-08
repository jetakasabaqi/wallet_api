package abc.workshop.wallet;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class WalletApplication {

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("CES"));
        SpringApplication.run(WalletApplication.class, args);
    }

}
