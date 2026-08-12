package br.com.orangebak.OrangeBank.Services;

import br.com.orangebak.OrangeBank.Models.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserJoin {

    private List<Users> listUsers = new ArrayList<>();

    public void saveUserCredentials(Users user)
    {
        listUsers.add(user);
    };

    public void Login() throws IOException {
        System.out.println("********************************");
        System.out.println("---- Welcome to Orange Bank ----");
        System.out.println("********************************");
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Type your option: ");
        System.out.println("1. Login");
        System.out.println("2. Create a new Account");
        int answerUser = keyboard.nextInt();

        switch (answerUser)
        {
            case 1:
                System.out.println("Type your Credentials");
                System.out.println("Your Email: ");
                String email = keyboard.next();
                System.out.println("Your Password");
                String password = keyboard.next();

                // Verificar se as credencias batem com as que estão no jsonl
                try {
                    FileReader reader = new FileReader("users.jsonl");
                    // Create memory buffer reader
                    BufferedReader buffer = new BufferedReader(reader);
                    String line;
                    while(true){
                        line = buffer.readLine();
                        System.out.println(line);
                        if (line == null){
                            break;
                        }
                    }
                    //reader.close();
                }catch (Exception e){
                    System.out.println("Error" + e);
                }
//
//                if(!){
//                    System.out.println("Access denied");
//                    System.out.println("Credentials invalid");
//                    break;
//                };

                System.out.println("Login realized with success");

                break;
            case 2:
                System.out.println("Fill in the fields below.");
                System.out.println("email: ");
                String emailUser = keyboard.next();
                System.out.println("confirm email");
                String emailUserConfirm = keyboard.next();
                System.out.println("password");
                String passwordUser = keyboard.next();

                if(!emailUser.equals(emailUserConfirm))
                {
                    System.out.println("Your email is invalid");
                    break;
                }

                if(passwordUser.length() <= 3){
                    System.out.println("Your password is weak, min character is 4");
                    break;
                }

                Users users = new Users(emailUser,passwordUser);
                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();


                String nameOfFile = "users.jsonl";
                saveUserCredentials(users);

                    FileWriter bdUsers = new FileWriter(nameOfFile, true);
                    bdUsers.write(gson.toJson(listUsers));
                    bdUsers.close();
                break;
            default:
                System.out.println("Invalid Options, type another valid number");
                break;
        }
    };
}
