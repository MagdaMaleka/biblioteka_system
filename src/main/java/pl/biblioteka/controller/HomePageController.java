package pl.biblioteka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pl.biblioteka.dao.BookDao;
import pl.biblioteka.domain.Book;

@RestController
public class HomePageController {

    @Value("${app.header.book}")
    private String title;

    @Autowired
    BookDao bookDao;

    @GetMapping(value = "/")
    public ModelAndView index(ModelAndView model) {
        model.addObject("title", title);
        model.setViewName("homePage");
        return model;
    }
}

