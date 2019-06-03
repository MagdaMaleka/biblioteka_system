package pl.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import pl.biblioteka.dao.BookDao;
import pl.biblioteka.domain.Book;

import java.util.List;

@RestController
public class BookController {

    @Value("${app.header.book}")
    private String title;

    @Autowired
    private BookDao bookDao;

    @GetMapping(value = "/books")
    public ModelAndView listBooks(ModelAndView model) {
        //System.out.println("books");

        //model.addAttribute("booksList", bookDao.findAll());

        List<Book> booksList = bookDao.findAll();
        booksList.sort((o1, o2) -> {
            if (o1.getId() == (o2.getId())) return 0;
            if (o1.getId() < o2.getId()) return -1;
            return 1;
        });
        model.addObject("booksList", booksList);
        model.setViewName("book");
        return model;
    }

    @PostMapping(value = "/orderBook")
    public RedirectView orderBook(@RequestParam String bookId, Model model) {
        System.out.println("order " + bookId);
        Book book = bookDao.findById(Integer.valueOf(bookId)).orElse(null);

        if (book.getStatus().equals("zarezerwowana") || book.getStatus().equals("dostępna")) {
            book.setStatus("pożyczona");
            bookDao.save(book);
            return new RedirectView("books");
        } else {
            return new RedirectView("books");
        }

    }

    @PostMapping(value = "/reserveBook")
    public RedirectView reserveBook(@RequestParam String bookId, Model model) {
        System.out.println("reserve " + bookId);
        Book book = bookDao.findById(Integer.valueOf(bookId)).orElse(null);

        if (book.getStatus().equals("dostępna")) {
            book.setStatus("zarezerwowana");
            bookDao.save(book);
            return new RedirectView("books");
        } else {
            return new RedirectView("books");
        }

/*        book.setStatus("zarezerwowana");
        bookDao.save(book);
        return new RedirectView("books");*/
    }

    @PostMapping(value = "/returnBook")
    public RedirectView returnBook(@RequestParam String bookId, Model model) {
        System.out.println("return " + bookId);
        Book book = bookDao.findById(Integer.valueOf(bookId)).orElse(null);
        book.setStatus("dostępna");
        bookDao.save(book);
        return new RedirectView("books");
    }
}

