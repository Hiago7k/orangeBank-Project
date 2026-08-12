package br.com.orangebak.OrangeBank;

import br.com.orangebak.OrangeBank.Services.UserJoin;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class OrangeBankApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(OrangeBankApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		UserJoin userjoin = new UserJoin();
		userjoin.Login();
	}
}
