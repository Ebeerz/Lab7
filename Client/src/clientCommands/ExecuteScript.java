package clientCommands;

import manager.CommandAndArg;

import java.io.IOException;

public class ExecuteScript implements clientCommands.Command {
    @Override
    public String execute(Object arg) throws IOException {
        CommandAndArg.setCommand("execute_script");
        CommandAndArg.setArg(arg);
        return null;
    }

    @Override
    public String getName() {
        return "execute_script";
    }

    @Override
    public String getDescription() {
        return "Считать и исполнить скрипт из указанного файла. В скрипте содержатся команды в таком же виде, в котором их вводит пользователь в интерактивном режиме.";
    }
}
