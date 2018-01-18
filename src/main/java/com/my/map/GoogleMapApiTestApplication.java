package com.my.map;





import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;




@SpringBootApplication
@EnableScheduling
public class GoogleMapApiTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleMapApiTestApplication.class, args);
	}
	

}
