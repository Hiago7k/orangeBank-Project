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
    private String password;
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
                password = keyboard.next();

               String json = "C:\\Projetos\\OrangeBank\\OrangeBank\\users.jsonl";

               Users users = new Users(email,password);
               Gson gson = new Gson();
               Users meuUsers = gson.fromJson(json, Users.class);
               System.out.println(meuUsers.toString());
                System.out.println("@#@#@#@#@#@#@#");

                try {
                    FileReader reader = new FileReader("users.jsonl");
                    BufferedReader buffer = new BufferedReader(reader);
                    while (true) {
                        String line = buffer.readLine();
                        if (line == null) {
                            break;
                        }

                        if(line.contains(email) || line.contains(password))
                        {
                            System.out.println("SUCCESS ACCESS REALIZED");
                            break;
                        } else {
                            System.out.println("FAIL");
                        }
                    }

                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                break;

            case 2:
                System.out.println("Fill in the fields below.");
                System.out.println("email: ");
                email = keyboard.next();
                System.out.println("password: ");
                password = keyboard.next();
                Users myUsers = new Users(email, password);

                if (password.length() <= 3) {
                    System.out.println("Your password is weak, min character is 4");
                    break;
                }

                 gson = new GsonBuilder()
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

