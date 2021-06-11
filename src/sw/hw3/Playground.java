package sw.hw3;

public class Playground {

    private String location;
    private float size;
    private float price;
    private String cancellationPeriod;
    private PlaygroundOwner playgroundOwner;

    Playground () { }

    Playground (String location, float size, float price, PlaygroundOwner playgroundOwner) {

        this.location = location;
        this.size = size;
        this.price = price;
        this.playgroundOwner = playgroundOwner;
    }

    public void setLocation (String location) {
        this.location = location;
    }

    public void setSize (float size) {
        this.size = size;
    }

    public void setPrice (float price) {
        this.price = price;
    }

    public void setPlaygroundOwner (PlaygroundOwner playgroundOwner) {
        this.playgroundOwner = playgroundOwner;
    }

    public String getLocation () {
        return location;
    }

    public float getSize () {
        return size;
    }

    public float getPrice () {
        return price;
    }

    public PlaygroundOwner getplaygroundOwner () {
        return playgroundOwner;
    }

    public String toString() {
        return  "Location: " + location + "\n"
                + "Size: " + size + "\n"
                + "Price per hour: " + price + "\n"
                + "Available playground owner: " + playgroundOwner + "\n";
    }
}

