package br.com.orangebak.OrangeBank.Services;

import br.com.orangebak.OrangeBank.Models.Users;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
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

                // validar se ja tenho um arquivo users.json criado


                Gson gson = new GsonBuilder()
                        .setPrettyPrinting()
                        .create();


                saveUserCredentials(users);
                FileWriter bdUsers = new FileWriter("users.json");
                bdUsers.write(gson.toJson(listUsers));
                bdUsers.close();
                // System Serealize login
                // Chegamos em um bloqueio toda vez que criamos uma conta
                // ele cria um arquivo json, porem se rodar de novo
                // ele vai sobrescrever o json antigo inves de apenas adicionar
                // um usuario abaixo
                // provavelmente vamos utilizar uma condicao para exists
                // se extiri ele apenas adiciona na lista


                break;
            default:
                System.out.println("Invalid Options, type another valid number");
                break;
        }
    };

}
