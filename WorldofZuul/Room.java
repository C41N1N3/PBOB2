import java.util.HashMap;
import java.util.Set;

public class Room {
    private String description;
    private HashMap<String, Room> exits;

    public Room(String description) {
        this.description = description;
        exits = new HashMap<>();
    }

    public void setExit(String direction, Room neighbor) {
        exits.put(direction, neighbor);
    }

    public Room getExit(String direction) {
        return exits.get(direction);
    }

    public String getLongDescription() {
        return "Anda sekarang berada " + description + ".\n" + getExitString();
    }
    
    private String getExitString() {
        String returnString = "Pintu keluar:";
        Set<String> keys = exits.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
}
