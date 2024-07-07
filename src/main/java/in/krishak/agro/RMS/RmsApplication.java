package in.krishak.agro.RMS;

import java.util.Arrays;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

@Slf4j
@SpringBootApplication
public class RmsApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RmsApplication.class);
		Environment environment = app.run(args).getEnvironment();

		Arrays.stream(environment.getActiveProfiles())
				.forEach(a -> log.info("Active Profiles: {}", a));
	}

}
