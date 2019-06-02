package pl.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.biblioteka.dao.BookDao;
import pl.biblioteka.domain.Book;

import java.util.List;

@RestController
public class DetailsController {

    @Value("${app.header.book}")
    private String title;

    @Autowired
    private BookDao bookDao;

    @GetMapping("/details")
    public ModelAndView listBooks(ModelAndView model, @RequestParam String bookId) {
        Book book = bookDao.findById(Integer.valueOf(bookId)).orElse(null);
        book.getOpis();
        model.addObject("book", book);
        model.setViewName("details");
        return model;
    }
}
