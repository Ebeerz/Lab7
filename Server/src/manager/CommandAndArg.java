package manager;

public class CommandAndArg {

    private static String command;
    private static Object arg;
    private static String user;
    private static String password;

    public static String getUser() {return user;}

    public static void setUser(String user) {CommandAndArg.user = user;}

    public static String getPassword() {return password;}

    public static void setPassword(String password) {CommandAndArg.password = password;}

    public static String getCommand() {
        return command;
    }

    public static void setCommand(String command) {
        CommandAndArg.command = command;
    }

    public static Object getArg() {
        return arg;
    }

    public static void setArg(Object arg) {
        CommandAndArg.arg = arg;
    }
}
