package net.kurochenko.ispubmaven.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Andrej Kuročenko <kurochenko@gmail.com>
 */
@Controller
public class AuthorController {
    
    @RequestMapping("/author")
    public ModelAndView renderAuthor() {
        String msg = "Hello, world!";
        return new ModelAndView("author", "hellomsg", msg);
    }
}
