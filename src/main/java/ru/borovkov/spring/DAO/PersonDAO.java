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

        people.add(new Person(++PEOPLE_COUNT, "First", 11, "First@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Second", 22, "Second@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Third", 33, "Third@yahoo.com"));
        people.add(new Person(++PEOPLE_COUNT, "Fourth", 44, "Fourth@gmail.com"));
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
        personToUpdate.setAge(person.getAge());
        personToUpdate.setEmail(person.getEmail());
    }

    public void delete(int id) {
        Person personToDelete = show(id);
        people.remove(personToDelete);
    }
    //public void delete(int id){
    //    people.removeIf(person -> person.getId() == id);
    //}

}