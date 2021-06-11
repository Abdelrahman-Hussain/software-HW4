package sw.hw3;

public class Request {
    private static int id=0;
    private int slot;
    private String state="Available";
    private String date;
    private Player player;
    private Playground playground;

    Request () { }

    Request (int slot, String date, Player player, Playground playground) {
        this.slot = slot;
        this.date = date;
        this.player = player;
        this.playground =playground;
        id++;
    }

    public void setSlots (int slot) {
        this.slot = slot;
    }

    public void setState (String state) {
        this.state = state;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public void setPlayer (Player player) {
        this.player = player;
    }

    public void setPlayground (Playground playground) {
        this.playground = playground;
    }

    public int getId () {
        return id;
    }

    public int getSlots () {
        return slot;
    }

    public String getState () {
        return state;
    }

    public String getDate () {
        return date;
    }

    public Player getPlayer () {
        return player;
    }

    public Playground getPlayground () {
        return playground;
    }

    public String toString() {
        return "Request ID:" + id + "\n"
                +"Player Name: " + player.getName() + "\n"
                + "Playground: " + playground.getLocation() + "\n"
                + "slot: " + slot + "\n"
                + "Date: " + date + "\n";
    }
}
