package Commands;

import manager.CommandAndArg;
import manager.Message;
import manager.SQLConnection;
import org.apache.commons.codec.digest.DigestUtils;

public class Login implements Command {

    @Override
    public String execute(Object o){
        String login = CommandAndArg.getUser();
        String md5password = DigestUtils.md5Hex(CommandAndArg.getPassword());
        if (SQLConnection.userExist(login, md5password)) {
            Message.setMessage("Вы успешно авторизовались");
        }
        else Message.setMessage("Ошибка авторизации, попробуйте другие данные");
        return null;
    }

    @Override
    public String getName() {return "login";}

    @Override
    public String getDescription() {return "авторизация";}
}
