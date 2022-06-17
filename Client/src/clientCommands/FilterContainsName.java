package clientCommands;

import manager.CommandAndArg;

public class    FilterContainsName implements clientCommands.Command {
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("filter_contains_name");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "filter_contains_name";
    }

    @Override
    public String getDescription() {
        return "Вывести элементы, значение поля name которых содержит заданную подстроку";
    }
}
