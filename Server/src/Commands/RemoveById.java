package Commands;

import Org.Product;
import Org.ProductCollection;
import manager.CommandAndArg;
import manager.Message;

import java.util.Iterator;
import java.util.Objects;

public class RemoveById implements Command{
    private static int count = 0;
    @Override
    public String execute(Object arg) {
        try {
            if (ProductCollection.getSize() == 0) {
                Message.setMessage("Коллекция пустая.");
            }
            else {


                Long id = Long.parseLong((String) arg);
                //ProductCollection.getCollection().removeIf(product -> Objects.equals(product.getId(), id) &&
                  //      product.getUser().equals(CommandAndArg.getUser()));


                for(Iterator<Product> it = ProductCollection.getCollection().iterator(); it.hasNext();)
                {
                    Product productIt = it.next();
                    if (productIt.getId().equals(Long.parseLong((String) arg))&&productIt.getUser().equals(CommandAndArg.getUser())) {
                        it.remove();
                        Message.setMessage("Был удален продукт с id: "+ arg);
                        count++;
                    }
                }


            }
            if (count == 0){Message.setMessage("Объект с id: " + arg + " не принадлежит вам или не существует");}
            return null;
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    @Override
    public String getName() {
        return "remove_by_id";
    }

    @Override
    public String getDescription() {
        return "Удаление элемента по заданному id";
    }
}
