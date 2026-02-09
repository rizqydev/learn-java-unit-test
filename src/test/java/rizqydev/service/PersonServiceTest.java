package rizqydev.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import rizqydev.test.data.Person;
import rizqydev.test.repository.PersonRepository;
import rizqydev.test.service.PersonService;

import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class PersonServiceTest {
    @Mock
    private PersonRepository personRepository;

    private PersonService personService;

    @BeforeEach
    void setUp() {
        personService = new PersonService(personRepository);
    }

    @Test
    void testPersonNotFound() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            personService.selectById(1);
        });
    }

    @Test
    void testPersonSuccess() {
        when(personRepository.selectById(1)).thenReturn(new Person(1, "rizqy"));
        var person = personService.selectById(1);

        Assertions.assertEquals(1, person.getId());
    }

    @Test
    void testRegisterSuccess() {
        var person = personService.register("rizqy");
        Assertions.assertEquals("rizqy", person.getName());
        Assertions.assertNotNull(person.getId());

        // when create insert we must verify that personRepository.save() is called
        verify(personRepository, times(1)).insert(new Person(person.getId(), person.getName()));
    }
}
