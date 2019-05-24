package pl.biblioteka.dao;

import org.springframework.data.repository.CrudRepository;
import pl.biblioteka.domain.Book;

public interface BookDao extends CrudRepository <Book, Integer> {
}
