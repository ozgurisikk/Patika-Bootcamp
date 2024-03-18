import java.util.Scanner;
public abstract class Location {
    private Player player;
    private String locationName;
    public static  Scanner input = new Scanner(System.in);

    public Location(Player p, String locationName) {
        this.player = p;
        this.locationName = locationName;

    }

    public abstract boolean onLocation();

    public Player getPlayer() {
        return player;
    }

    public void setPlayer(Player player) {
        this.player = player;
    }

    public String getLocationName() {
        return locationName;
    }

    public void setLocationName(String locationName) {
        this.locationName = locationName;
    }
}
