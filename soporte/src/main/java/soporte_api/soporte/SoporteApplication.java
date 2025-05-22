package soporte_api.soporte;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;


@EnableFeignClients(basePackages = "soporte_api.soporte.service")

@SpringBootApplication
public class SoporteApplication {

	public static void main(String[] args) {
		SpringApplication.run(SoporteApplication.class, args);
	}

}
