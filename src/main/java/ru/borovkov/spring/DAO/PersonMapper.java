package ru.borovkov.spring.DAO;

import org.springframework.jdbc.core.RowMapper;
import ru.borovkov.spring.models.Person;

import java.sql.ResultSet;
import java.sql.SQLException;

public class PersonMapper implements RowMapper<Person> {
    @Override
    public Person mapRow(ResultSet resultSet, int i) throws SQLException {
        Person person = new Person();
        person.setId(resultSet.getInt("id"));
        person.setName(resultSet.getString("name"));
        person.setAge(resultSet.getInt("age"));
        person.setEmail(resultSet.getString("email"));
        return person;
    }
    //код тривиальный, т.е. setId = "id".
    // Такой RowMapper есть базовый - BeanPropertyRowMapper<>(Person.class)
}
