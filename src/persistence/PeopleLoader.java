package persistence;

import java.util.List;
import model.Person;

public interface PeopleLoader {
    public List<Person> load();
}
