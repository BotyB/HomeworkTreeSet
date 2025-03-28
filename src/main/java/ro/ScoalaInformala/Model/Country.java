package ro.ScoalaInformala.Model;

public final class Country {
    public static final Country ROMANIA = new Country("Romania");
    public static final Country USA = new Country("United States");
    public static final Country GERMANY = new Country("Germany");
    public static final Country FRANCE = new Country("France");
    public static final Country ITALY = new Country("Italy");
    public static final Country SPAIN = new Country("Spain");
    public static final Country GREECE = new Country("Greece");
    public static final Country SWITZERLAND = new Country("Switzerland");
    public static final Country UK = new Country("United Kingdoms");
    public static final Country JAPAN = new Country("Japan");
    public static final Country POLAND = new Country("Poland");
    public static final Country AUSTRIA = new Country("Austria");

    private final String name;

    private Country(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return name;
    }
}