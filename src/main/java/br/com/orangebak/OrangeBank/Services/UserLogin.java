package br.com.orangebak.OrangeBank.Services;

import br.com.orangebak.OrangeBank.Models.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserLogin {

    private String email;
    private String psswd;
    private Scanner keyboard = new Scanner(System.in);

    private List<Users> listUsers = new ArrayList<>();
    private List<String> usersHistory = new ArrayList<>();
    public void saveUserCredentials(Users users) {
        listUsers.add(users);
    };

    public void Login() throws IOException {
        System.out.println("Type your option: ");
        System.out.println("1. Login");
        System.out.println("2. Create a new Account");
        int answerUser = keyboard.nextInt();


        switch (answerUser) {

            case 1:
                System.out.println("Type your Credentials");
                System.out.println("Your Email: ");
                email = keyboard.next();
                System.out.println("Your Password");
                psswd = keyboard.next();

                try {
                    for(var check : listUsers){
                        System.out.println("Exibindo usuarios ja cadastrados");
                        System.out.println(check);
                    };

                    FileReader reader = new FileReader("users.jsonl");
                    BufferedReader buffer = new BufferedReader(reader);
                    while (true) {
                        String line = buffer.readLine();
                        if (line == null) {
                            break;
                        }
                        usersHistory.add(line);
                    }
                    for (var check : usersHistory) {
                        if(email.equals(check) && psswd.equals(check))
                        {
                            System.out.println("Access Allowed");
                        }else {
                            System.out.println("Access Denied");
                            break;
                        }
                    }
                } catch (Exception e) {
                    System.out.println("Error" + e);
                    System.out.println("caiu no catch");
                }

                System.out.println("Caiu fora do try e catch");
                break;


            case 2:

                System.out.println("Fill in the fields below.");
                System.out.println("email: ");
                email = keyboard.next();
                System.out.println("password: ");
                psswd = keyboard.next();
                Users myUsers = new Users(email, psswd);

                if (psswd.length() <= 3) {
                    System.out.println("Your password is weak, min character is 4");
                    break;
                }

                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();
                String nameOfFile = "users.jsonl";

                FileWriter bdUsers = new FileWriter(nameOfFile, true);
                bdUsers.write(gson.toJson(myUsers));
                System.out.println("salvando informações no nosso banco de dados");
                saveUserCredentials(myUsers);
                bdUsers.close();

                break;
            default:
                System.out.println("Invalid Options, type another valid number");
                break;
        };
    };
};

