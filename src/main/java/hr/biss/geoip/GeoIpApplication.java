package hr.biss.geoip;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class GeoIpApplication {

	public static void main(String[] args) {
		SpringApplication.run(GeoIpApplication.class, args);
	}

}
