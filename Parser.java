import java.util.Scanner;

public class Parser {
    private CommandWords commands;
    private Scanner reader;

    public Parser() {
        commands = new CommandWords();
        reader = new Scanner(System.in);
    }

    public Command getCommand() {
        String inputLine;
        String word1 = "";
        String word2 = null;

        System.out.print("> "); 
        inputLine = reader.nextLine();

        Scanner tokenizer = new Scanner(inputLine);
        if(tokenizer.hasNext()) {
            word1 = tokenizer.next().toLowerCase();
            if(tokenizer.hasNext()) {
                word2 = tokenizer.next().toLowerCase();
            }
        }

        CommandWord commandWord = commands.getCommandWord(word1);
        return new Command(commandWord, word2);
    }
    
    public String showCommands() {
        return commands.getCommandList();
    }
}
                