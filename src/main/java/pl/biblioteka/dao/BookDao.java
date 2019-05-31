package pl.biblioteka.dao;

import org.springframework.data.repository.CrudRepository;
import pl.biblioteka.domain.Book;

import java.util.List;

public interface BookDao extends CrudRepository <Book, Integer> {

    List<Book> findAll();
}
