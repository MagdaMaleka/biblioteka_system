package pl.biblioteka.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class HomePageController {

    @Value("${app.header.book}")
    private String title;

    @GetMapping(value="/")
    public ModelAndView index(ModelAndView model) {
        model.addObject("title", title);
        model.setViewName("homePage");
        return model;
    }
}

