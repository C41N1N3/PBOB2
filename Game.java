
public class Game {
    private Parser parser;
    private Room currentRoom;
        
    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room outside, theater, pub, lab, office;
        outside = new Room("di luar gerbang utama universitas");
        theater = new Room("di dalam sebuah teater");
        pub = new Room("di dalam pub kampus");
        lab = new Room("di dalam lab komputer");
        office = new Room("di ruang admin komputasi");

        outside.setExit("east", theater);
        outside.setExit("south", lab);
        outside.setExit("west", pub);
        theater.setExit("west", outside);
        pub.setExit("east", outside);
        lab.setExit("north", outside);
        lab.setExit("east", office);
        office.setExit("west", lab);
        currentRoom = outside;
    }

    public void play() {            
        printWelcome();
        boolean finished = false;
        while (! finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Terima kasih telah bermain. Sampai jumpa.");
    }

    private void printWelcome() {
        System.out.println("\nSelamat datang di World of Zuul!");
        System.out.println("Ketik 'help' jika Anda butuh bantuan.");
        System.out.println(currentRoom.getLongDescription());
    }

    private boolean processCommand(Command command) {
        boolean wantToQuit = false;
        CommandWord commandWord = command.getCommandWord();

        switch (commandWord) {
            case UNKNOWN:
                System.out.println("Saya tidak mengerti apa maksud Anda...");
                break;
            case HELP:
                printHelp();
                break;
            case GO:
                goRoom(command);
                break;
            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    private void printHelp() {
        System.out.println("Anda tersesat. Anda sendirian.");
        System.out.println("\n--- TUTORIAL CARA BERMAIN ---");
        System.out.println("1. Ketik 'go' diikuti arah (contoh: 'go north') untuk berpindah.");
        System.out.println("2. Ketik 'help' untuk melihat bantuan ini lagi.");
        System.out.println("3. Ketik 'quit' untuk keluar dari permainan.");
        System.out.println("\nPerintah yang bisa Anda gunakan:");
        System.out.println("   " + parser.showCommands());
    }

    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            System.out.println("Pergi ke mana?");
            return;
        }
        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("Tidak ada pintu ke arah situ!");
        }
        else {
            currentRoom = nextRoom;
            System.out.println(currentRoom.getLongDescription());
        }
    }

    private boolean quit(Command command) {
        if(command.hasSecondWord()) {
            System.out.println("Keluar dari apa?");
            return false;
        }
        else {
            return true;
        }
    }
    
    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}