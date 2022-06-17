package clientCommands;

import Org.Product;
import manager.CommandAndArg;

public class RemoveLower implements clientCommands.Command {

    @Override
    public String execute(Object arg) {
        clientCommands.ProductCreator productCreator = new clientCommands.ProductCreator();
        Product product = productCreator.create((String) arg);

        CommandAndArg.setCommand("remove_lower");
        CommandAndArg.setArg(product);

        return null;
    }

    @Override
    public String getName() {
        return "remove_lower";
    }

    @Override
    public String getDescription() {
        return "удалить из коллекции все элементы, меньшие, чем заданный";
    }
}
