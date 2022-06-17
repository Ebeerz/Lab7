package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.Message;

public class Add implements Command {
    @Override
    public String execute(Object arg) {
        Product product = (Product) arg;
        System.out.println(product.toString());
        ProductCollection.add(product);
        System.out.println(ProductCollection.getCollection().toString());
        Message.setMessage("Был добавлен продукт");
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
