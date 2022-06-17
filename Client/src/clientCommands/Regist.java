package clientCommands;

import manager.CommandAndArg;

import java.util.Scanner;

public class Regist implements Command {
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public String execute(Object o) {
        CommandAndArg.setCommand("registration");
        System.out.println("Введите имя пользователя");
        String user = scanner.nextLine();
        CommandAndArg.setUser(String.valueOf(user));
        System.out.println("Введите пароль");
        String password = scanner.nextLine();
        CommandAndArg.setPassword(password);
        return null;
    }

    @Override
    public String getName() {
        return "registration";
    }

    @Override
    public String getDescription() {
        return "Регистрация";
    }
}

