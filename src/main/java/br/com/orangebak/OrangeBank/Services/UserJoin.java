package br.com.orangebak.OrangeBank.Services;

import com.google.gson.Gson;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class UserJoin {


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

                Gson gson = new Gson();
                gson.newBuilder()
                        .setPrettyPrinting()
                        .create();

                FileWriter users = new FileWriter("users.json");
                users.write(gson.toJson(Users));
                users.close();

                // System Serealize login

                break;
            default:
                System.out.println("Invalid Options, type another valid number");
                break;
        }
    };

}
