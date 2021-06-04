package handler;

public class YoCommand {
    private final String commandName;
    private final String userPath;

    public YoCommand(String commandName, String userPath){
        this.commandName = commandName;
        this.userPath = userPath;
    }

    public String getUserPath() {
        return userPath;
    }

    public String getCommandName() {
        return commandName;
    }
}
