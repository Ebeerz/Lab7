package clientCommands;

import manager.CommandAndArg;

public class RemoveAnyByPrice implements clientCommands.Command {
    @Override
    public String execute(Object arg) {
        CommandAndArg.setCommand("remove_any_by_price");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "remove_any_by_price";
    }

    @Override
    public String getDescription() {
        return "Удаление одного объекта с заданным полем price";
    }
}
