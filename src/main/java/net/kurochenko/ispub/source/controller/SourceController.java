package net.kurochenko.ispub.source.controller;

import net.kurochenko.ispub.source.form.Source;
import net.kurochenko.ispub.source.service.SourceService;
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

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 1:53 PM
 * To change this template use File | Settings | File Templates.
 */
@Controller
@RequestMapping("/source")
public class SourceController {
    @Autowired
    SourceService sourceService;


    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("source") Source source, BindingResult result) {

        sourceService.saveSource(source);
        return "redirect:/source";
    }

    @RequestMapping(value = "/save", method= RequestMethod.GET)
    public String renderContact(Model model, @ModelAttribute Source source, WebRequest request) {
        return "source.save";
    }

    @RequestMapping(value="/save/{sourceId}", method = RequestMethod.GET)
    public String renderUpdateForm(@PathVariable("sourceId") Integer sourceId, ModelMap model) {
        model.addAttribute("source", sourceService.getByID(sourceId));
        return "source.save";
    }

    @RequestMapping(value="/save/{sourceId}", method = RequestMethod.POST)
    public String updateAuthor(@ModelAttribute("sourceId") Source source, BindingResult result, SessionStatus status) {
        sourceService.saveSource(source);
        status.setComplete();
        return "redirect:/source";
    }

    @RequestMapping("/delete/{sourceId}")
    public String deleteContact(@PathVariable("sourceId") Integer sourceId) {

        sourceService.removeSource(sourceId);
        return "redirect:/source";
    }
}
