package helpers;

public class Ticket {
    public String firstCity;
    public String secondCity;

    private Ticket(String firstCity, String secondCity) {
        this.firstCity = firstCity;
        this.secondCity = secondCity;
    }

    public static Ticket valueOf(String firstCity, String secondCity) {
        return new Ticket(firstCity, secondCity);
    }
}

