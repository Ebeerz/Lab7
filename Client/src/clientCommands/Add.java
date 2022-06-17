package clientCommands;

import Org.Product;
import manager.CommandAndArg;

public class Add implements clientCommands.Command {
    @Override
    public String execute(Object arg) {
        clientCommands.ProductCreator productCreator = new clientCommands.ProductCreator();
        Product product = productCreator.create((String) arg);
        if (product != null){
            product.setUser(CommandAndArg.getUser());
            //System.out.println(product.getUser());
            CommandAndArg.setCommand("add");
            CommandAndArg.setArg(product);
            return null;
        }
        CommandAndArg.setCommand("");
        return null;
    }

    @Override
    public String getName() {
        return "add";
    }

    @Override
    public String getDescription() {
        return "добавление объекта";
    }
}
