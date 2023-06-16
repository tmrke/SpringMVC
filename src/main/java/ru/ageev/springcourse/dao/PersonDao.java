package ru.ageev.springcourse.dao;

import org.springframework.stereotype.Component;
import ru.ageev.springcourse.model.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDao {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "Person1", 20, "person1@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Person2", 22, "person2@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Person3", 24, "person3@mail.com"));
        people.add(new Person(++PEOPLE_COUNT, "Person4", 26, "person4@mail.com"));
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
        Person personToUpdate = show(id);
        personToUpdate.setName(person.getName());
        personToUpdate.setAge(person.getAge());
        personToUpdate.setEmail(person.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}

