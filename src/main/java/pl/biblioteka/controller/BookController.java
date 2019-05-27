package pl.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.biblioteka.domain.Book;
import pl.biblioteka.helper.BookImpl;

import java.io.IOException;
import java.util.List;

@RestController
public class BookController {

        @Value("${app.header.book}")
        private String title;

        @Autowired
        private BookImpl book;

        @GetMapping("/books")
        public ModelAndView ListBooks(ModelAndView model) throws IOException {
            List<Book> listBooks = book.findAll();
            model.addObject("books", listBooks);
            model.setViewName("book");
            return model;
        }

    }

