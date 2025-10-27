import java.util.HashMap;

public class CommandWords {
    private HashMap<String, CommandWord> validCommands;

    public CommandWords() {
        validCommands = new HashMap<>();
        for(CommandWord command : CommandWord.values()) {
            if(command != CommandWord.UNKNOWN) {
                validCommands.put(command.toString(), command);
            }
        }
    }

    public CommandWord getCommandWord(String aString) {
        CommandWord command = validCommands.get(aString);
        if(command != null) {
            return command;
        }
        else {
            return CommandWord.UNKNOWN;
        }
    }

    public String getCommandList() {
        String commandList = "";
        for(String command : validCommands.keySet()) {
            commandList += command + " ";
        }
        return commandList.trim();
    }
}
