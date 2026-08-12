package br.com.orangebak.OrangeBank;

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
		System.out.println("********************************");
		System.out.println("---- Welcome to Orange Bank ----");
		System.out.println("********************************");
		Scanner keyboard = new Scanner(System.in);

		System.out.println("Type your option: ");
		System.out.println("1. Login");
		System.out.println("2. Create a new Account");



	}
}
