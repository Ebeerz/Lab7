package clientCommands;

import manager.CommandAndArg;

public class Clear implements clientCommands.Command {
    @Override
    public String execute(Object o) {
        CommandAndArg.setCommand("clear");
        return null;
    }

    @Override
    public String getName() {
        return "clear";
    }

    @Override
    public String getDescription() {
        return "Очищение коллекции";
    }
}
