package rizqydev.test.service;

import rizqydev.test.data.Person;
import rizqydev.test.repository.PersonRepository;

import java.util.Random;

public class PersonService {
    private PersonRepository personRepository;

    public PersonService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    public Person selectById(int id) {
        Person person =  personRepository.selectById(id);

        if (person == null) throw new IllegalArgumentException("Person not found");

        return person;
    }

    public Person register(String name) {
        var person = new Person((int) (Math.random() * 101), name);

        personRepository.insert(person);

        return person;
    }
}
