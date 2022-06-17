package clientCommands;

import manager.CommandAndArg;

public class CountGreaterThanManufacturer implements clientCommands.Command {
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("count_greater_than_manufacturer manufacturer");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "count_greater_than_manufacturer";
    }

    @Override
    public String getDescription() {
        return "Вывести количество элементов, значение поля manufacturer которых больше заданного";
    }
}
