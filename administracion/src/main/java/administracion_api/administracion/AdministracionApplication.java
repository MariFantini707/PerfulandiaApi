package administracion_api.administracion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients(basePackages = "administracion_api.administracion.service")

@SpringBootApplication
public class AdministracionApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdministracionApplication.class, args);
	}

}
