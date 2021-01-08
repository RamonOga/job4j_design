package ru.job4j.io.chatbot;

import java.util.Scanner;

public class UserInterface {

    private Scanner scan = new Scanner(System.in);

    public String scanUserData() {
        String rsl = scan.nextLine();
        return rsl;
    }

    public void sayHello() {
        System.out.println("Приветствую тебя! Я бот, поговори со мной.");
        System.out.println("Если хочешь чтобы я заткнулся, скажи \"стоп\" ");
        System.out.println("Если хочешь чтобы сново заговорил, скажи \"продолжить\" ");
        System.out.println("Если хочешь выйти, скажи \"закончить\" ");
    }
}
