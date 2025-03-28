package ro.ScoalaInformala.Comparator;

import ro.ScoalaInformala.Model.Person;
import java.util.Comparator;

public class PersonAgeComparator implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        return Integer.compare(p1.getAge(), p2.getAge());
    }
}