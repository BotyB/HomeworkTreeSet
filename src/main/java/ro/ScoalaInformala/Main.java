package ro.ScoalaInformala;

import ro.ScoalaInformala.Comparator.*;
import ro.ScoalaInformala.Model.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Address> cyclingAddresses = Arrays.asList(
                new Address("Transfăgărășan Highway", Country.ROMANIA),
                new Address("Black Forest Trail", Country.GERMANY),
                new Address("French Alps Route", Country.FRANCE)
        );

        List<Address> swimmingAddresses = Arrays.asList(
                new Address("Mamaia Beach", Country.ROMANIA),
                new Address("Mediterranean Coast", Country.SPAIN),
                new Address("Aegean Sea Resorts", Country.GREECE)
        );

        List<Address> photographyAddresses = Arrays.asList(
                new Address("Eiffel Tower", Country.FRANCE),
                new Address("Colosseum", Country.ITALY),
                new Address("Sagrada Familia", Country.SPAIN)
        );

        List<Address> paintingAddresses = Arrays.asList(
                new Address("Louvre Museum", Country.POLAND),
                new Address("Van Gogh Museum", Country.GERMANY),
                new Address("Street Art Wall", Country.AUSTRIA)
        );

        Hobby cycling = new Hobby("Cycling", 3, cyclingAddresses);
        Hobby swimming = new Hobby("Swimming", 2, swimmingAddresses);
        Hobby photography = new Hobby("Photography", 4, photographyAddresses);
        Hobby hiking = new Hobby("Mountain Hiking", 2, Arrays.asList(
                new Address("Carpathian Mountains", Country.ROMANIA),
                new Address("Swiss Alps", Country.SWITZERLAND)
        ));
        Hobby gaming = new Hobby("eSports", 5, Collections.singletonList(
                new Address("Home Setup", Country.USA)
        ));
        Hobby reading = new Hobby("Book Reading", 7, Arrays.asList(
                new Address("Local Library", Country.UK),
                new Address("Home Study", Country.JAPAN)
        ));
        Hobby painting = new Hobby("Painting", 6, Arrays.asList(
                new Address("Braunau am Inn", Country.AUSTRIA),
                new Address("Unter den Linden and Ebertstraße", Country.GERMANY)
        ));


        Person student = new Student("Alice Smith", 20, "Harvard University");
        Person employee = new Hired("Bob Johnson", 35, "UBISOFT");
        Person unemployed = new Unemployed("Charlie Brown", 28);
        Person student1 = new Student("Emma Watson", 32, "Oxford University");
        Person student2 = new Student("Tim Cook", 24, "MIT");
        Person employee1 = new Hired("Sundar Pichai", 50, "Google");
        Person employee2 = new Hired("Gabe Newell", 60, "Valve Corporation");
        Person unemployed1 = new Unemployed("Adolf Schickelgruber", 45); //Hitler
        Person unemployed2 = new Unemployed("Jane Smith", 38);

        student.setHobbies(Arrays.asList(cycling, photography));
        employee.setHobbies(Collections.singletonList(gaming));
        unemployed.setHobbies(Arrays.asList(swimming, reading));
        student1.setHobbies(Arrays.asList(hiking, photography));
        student2.setHobbies(Collections.singletonList(cycling));
        employee1.setHobbies(Arrays.asList(reading, gaming));
        employee2.setHobbies(Collections.singletonList(hiking));
        unemployed1.setHobbies(Arrays.asList(swimming, cycling, painting));
        unemployed2.setHobbies(Collections.singletonList(photography));

        TreeSet<Person> byName = new TreeSet<>(new PersonNameComparator());
        TreeSet<Person> byAge = new TreeSet<>(new PersonAgeComparator());

        List<Person> allPeople = Arrays.asList(
                student, employee, unemployed, student1, student2,
                employee1, employee2, unemployed1, unemployed2
        );

        byName.addAll(allPeople);
        byAge.addAll(allPeople);

        Map<Person, List<Hobby>> hobbiesMap = new HashMap<>();
        allPeople.forEach(person -> hobbiesMap.put(person, person.getHobbies()));

        System.out.println("--- People sorted by name ---");
        byName.forEach(p -> System.out.println(p.getName() + "  Age: " + "(" + p.getAge() + " years old)"));

        System.out.println("\n--- People sorted by age ---");
        byAge.forEach(p -> System.out.println(p.getName() + "  Age: " + "(" + p.getAge() + " years old)"));

        System.out.println("\n--- Hobby details ---");
        hobbiesMap.forEach((person, hobbies) -> {
            System.out.println("\n" + person.getName() + "  Age: " + "(" + person.getAge() + " years old)" + "\n Hobbies: ");
            hobbies.forEach(hobby -> {
                System.out.println(" - " + hobby.getName()  + "(" + hobby.getFrequency() + "/week)");
                System.out.println("   Countries:");
                hobby.getAddresses().forEach(address ->
                        System.out.println("   @ " + address.getCountry().getName()));
            });
        });
    }
}