package ro.ScoalaInformala.Model;

public class Address {
    private final String street;
    private final Country country;

    public Address(String street, Country country) {
        this.street = street;
        this.country = country;
    }

    public Country getCountry() {
        return country;
    }

    @Override
    public String toString() {
        return street + ", " + country.getName();
    }
}