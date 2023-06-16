package ru.ageev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.ageev.springcourse.model.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Person1"));
        people.add(new Person(++PEOPLE_COUNT, "Person2"));
        people.add(new Person(++PEOPLE_COUNT, "Person3"));
        people.add(new Person(++PEOPLE_COUNT, "Person4"));
    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(Person person, int id) {
        show(id).setName(person.getName());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}

