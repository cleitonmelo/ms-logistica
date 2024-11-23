package br.com.techchalleng4.mslogistica;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class MslogisticaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MslogisticaApplication.class, args);
	}

}
