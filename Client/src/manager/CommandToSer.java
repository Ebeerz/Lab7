package manager;

import java.io.Serial;
import java.io.Serializable;

public class CommandToSer implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private String command;
    private Object arg;
    private String user;
    private String password;

    public CommandToSer(String command, Object arg, String user, String password) {
        this.command = command;
        this.arg = arg;
        this.user = user;
        this.password = password;
    }

    public String getUser() {return user;}

    public void setUser(String user) {this.user = user;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public Object getArg() {
        return arg;
    }

    public void setArg(Object arg) {
        this.arg = arg;
    }

    @Override
    public String toString() {
        return "CommandAndArg{" +
                "command='" + command + '\'' +
                ", arg=" + arg +
                '}';
    }
}
