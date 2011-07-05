package net.kurochenko.ispub.author.controller;

import java.util.Map;
import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.author.service.AuthorService;
import net.kurochenko.ispub.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.context.request.WebRequest;

/**
 *
 * @author Andrej Kuročenko <kurochenko@gmail.com>
 */
@Controller
@RequestMapping("/author")
public class AuthorController {
    
    @Autowired
    private AuthorService authorService;
    
    @Autowired
    private DepartmentService departmentService;

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
 
        model.addAttribute("departmentList", departmentService.listDepartment());
        
        return "author.save";
    }

    @RequestMapping(value="/save/{authorId}", method = RequestMethod.GET)
    public String renderUpdateForm(@PathVariable("authorId") Integer authorId, ModelMap model) {
        model.addAttribute("author", authorService.getAuthorByID(authorId));
        
        model.addAttribute("departmentList", departmentService.listDepartment());
        return "author.save";
    }

    @RequestMapping(value="/save/{authorId}", method = RequestMethod.POST)
    public String updateAuthor(@ModelAttribute("idAuthor") Author author, BindingResult result, SessionStatus status) {
        authorService.updateAuthor(author);
        status.setComplete();
        return "redirect:/author";
    }
    
    @RequestMapping("/delete/{authorId}")
    public String deleteContact(@PathVariable("authorId")
    Integer authorId) {
 
        authorService.removeAuthor(authorId);
 
        return "redirect:/author";
    }
}
