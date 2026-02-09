package rizqydev.test.repository;

import rizqydev.test.data.Person;

public interface PersonRepository {
    Person selectById(int id);
    void insert(Person person);
}
