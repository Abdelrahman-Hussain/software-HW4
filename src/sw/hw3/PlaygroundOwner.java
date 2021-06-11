package sw.hw3;

public class PlaygroundOwner {

    private String name;
    private String password;
    private String mail;
    private String phone;
    private String address;

    PlaygroundOwner () {}

    PlaygroundOwner (String name, String password, String mail, String address, String phone) {
        this.name = name;
        this.password = password;
        this.mail = mail;
        this.address = address;
        this.phone = phone;
    }

    public void setName (String name) {
        this.name = name;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public void setMail (String mail) {
        this.mail = mail;
    }

    public void setPhone (String phone) {
        this.phone = phone;
    }

    public void setAddress (String address) {
        this.address = address;
    }
    
    public String getName () {
        return name;
    }

    public String getPassword () {
        return password;
    }

    public String getMail () {
        return mail;
    }

    public String getPhone () {
        return phone;
    }

    public String getAddress () {
        return address;
    }

    public String toString() {
        return "Player Name: " + name + "\n"
                + "Address: " + address + "\n"
                + "Phone: " + phone + "\n"
                + "Mail: " + mail + "\n";
    }

}

