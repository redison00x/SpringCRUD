package ru.borovkov.spring.DAO;

import org.springframework.stereotype.Component;
import ru.borovkov.spring.models.Person;

import java.util.ArrayList;
import java.util.List;

@Component
public class PersonDAO {
    private static int PEOPLE_COUNT;
    private List<Person> people;

    {
        people = new ArrayList<>();

        people.add(new Person(++PEOPLE_COUNT, "1"));
        people.add(new Person(++PEOPLE_COUNT, "2"));
        people.add(new Person(++PEOPLE_COUNT, "3"));
        people.add(new Person(++PEOPLE_COUNT, "4"));
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

    public void update(int id, Person person) {
        Person personToUpdate = show(id);
        personToUpdate.setName(person.getName());
    }

    public void delete(int id) {
        Person personToDelete = show(id);
        people.remove(personToDelete);
    }
    //public void delete(int id){
    //    people.removeIf(person -> person.getId() == id);
    //}

}