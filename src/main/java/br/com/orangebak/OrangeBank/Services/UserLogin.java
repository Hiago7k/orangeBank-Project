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

public class UserLogin   {

    private String email;
    private String psswd;
    private Scanner keyboard = new Scanner(System.in);

    private List<Users> listUsers = new ArrayList<>();

    public void saveUserCredentials(Users users)
    {
        listUsers.add(users);
    };

    public void Login() throws IOException {
        System.out.println("********************************");
        System.out.println("---- Welcome to Orange Bank ----");
        System.out.println("********************************");

        System.out.println("Type your option: ");
        System.out.println("1. Login");
        System.out.println("2. Create a new Account");
        int answerUser = keyboard.nextInt();



        switch (answerUser)
        {
           // Users myUsers = new Users(email, psswd);

        case 1:
//                System.out.println("Type your Credentials");
//                System.out.println("Your Email: ");
//                email = keyboard.next();
//                System.out.println("Your Password");
//                psswd = keyboard.next();
//
//                for (var info : listUsers){
//                    System.out.println("*******************************************************");
//                    System.out.println("Showing all users credntials has been registreds");
//                    System.out.println(info.email());
//                    System.out.println(info.password());
//                    System.out.println("*******************************************************");
//                }
//
//
//                try {
//                    FileReader reader = new FileReader("users.jsonl");
//                    BufferedReader buffer = new BufferedReader(reader);
//
//                    while(true){
//                        String  line = buffer.readLine();
//
//                        if (!myUsers.email().equals(line) && myUsers.password().equals(line))
//                        {
//                            System.out.println("Caiu na validação de que a senha e login não existem no banco de json");
//                            System.out.println("Access denied, credentials not found");
//                            break;
//                        }
//                        System.out.println(myUsers.toString());
//                        if (line == null){
//                            break;
//                        }
//                        System.out.println("caiu no try");
//                    }
//                }catch (Exception e){
//                    System.out.println("Error" + e);
//                    System.out.println("caiu no catch");
//                }
//
//                System.out.println("Caiu fora do try e catch");
                break;

            case 2:

                System.out.println("Fill in the fields below.");
                System.out.println("email: ");
                email = keyboard.next();
                System.out.println("password: ");
                psswd = keyboard.next();
                Users myUsers = new Users(email, psswd);

                if(psswd.length() <= 3){
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

