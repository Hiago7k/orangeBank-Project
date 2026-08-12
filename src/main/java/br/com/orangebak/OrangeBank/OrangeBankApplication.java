package br.com.orangebak.OrangeBank;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OrangeBankApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrangeBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("********************************");
		System.out.println("---- Welcome to Orange Bank ----");
		System.out.println("********************************");



	}
}
