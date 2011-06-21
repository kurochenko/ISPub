package net.kurochenko.ispub.author.controller;

import java.util.Map;
import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author Andrej Kuročenko <kurochenko@gmail.com>
 */
@Controller
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map) {
 
        map.put("author", new Author());
        map.put("authorList", authorService.listAuthor());
 
        return "author";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("author")
    Author author, BindingResult result) {
 
        authorService.saveAuthor(author);
 
        return "redirect:/author";
    }
    
    @RequestMapping(value = "/save", method= RequestMethod.GET)
    public String renderContact(Model model, @ModelAttribute Author author, WebRequest request) {
 
        return "author.save";
    }
    
    @RequestMapping("/delete/{authorId}")
    public String deleteContact(@PathVariable("authorId")
    Integer authorId) {
 
        authorService.removeAuthor(authorId);
 
        return "redirect:/author";
    }
    
    @RequestMapping(value = "/update/{authorId}", method= RequestMethod.GET)
    public ModelAndView updateContact(@PathVariable("authorId") Integer authorId) {
        
        return new ModelAndView("author.update", "author", authorService.getAuthorByID(authorId));
    }

    @RequestMapping(value="/save/{authorId}", method = RequestMethod.GET)
    public String setupForm(@PathVariable("authorId") Integer authorId, ModelMap model) {
        model.addAttribute("author", authorService.getAuthorByID(authorId));
        
        return "author.save";
    }

    @RequestMapping(value="/save/{authorId}", method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("idAuthor") Author author, BindingResult result, SessionStatus status) {
        authorService.saveAuthor(author);
        status.setComplete();
        return "redirect:/author";
    }
}
