package Commands;

import manager.CommandAndArg;
import manager.Message;
import manager.SQLConnection;
import org.apache.commons.codec.digest.DigestUtils;

public class Regist implements Command {

    @Override
    public String execute(Object o){
        String login = CommandAndArg.getUser();
        String md5password = DigestUtils.md5Hex(CommandAndArg.getPassword());
        System.out.println("пароль захэширован");
        if (!SQLConnection.alreadyUserExist(login)){
            if (SQLConnection.addNewUser(login, md5password)) {
                Message.setMessage("Вы успешно зарегистрировались");
            }
        }
        else Message.setMessage("Ошибка регистрации, пользователь с таким именем уже существует");
        return null;
    }

    @Override
    public String getName() {return "registration";}

    @Override
    public String getDescription() {return "регистрация";}
}
