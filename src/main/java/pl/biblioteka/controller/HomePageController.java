package pl.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.biblioteka.dao.BookDao;
import pl.biblioteka.domain.Book;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
public class HomePageController {

    @Value("${app.header.book}")
    private String title;

    @Autowired
    BookDao bookDao;

    @GetMapping(value = "/")
    public ModelAndView index(ModelAndView model) {

/*        Iterable<Book> bookIterable = bookDao.findAll();
        Collection<Book> bookCollection = (Collection<Book>) bookIterable;
        Map<String, Long> dataMap = bookCollection.stream()
                .collect(Collectors.groupingBy(Book::getTytul, Collectors.counting()));

        List<String> labels = Book.bookIterable(dataMap.keySet());

        model.addObject("title", title);
        model.addObject("dataMap", dataMap);
        //model.addObject("labels", labels);

        return model;
        }*/
        model.addObject("title", title);
        model.setViewName("homePage");
        return model;
    }
}

