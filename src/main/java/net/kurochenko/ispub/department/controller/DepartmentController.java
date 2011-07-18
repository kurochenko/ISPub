package net.kurochenko.ispub.department.controller;

import java.util.Map;
import javax.validation.Valid;
import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.department.service.DepartmentService;
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

@Controller
@RequestMapping("/department")
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @RequestMapping(method = RequestMethod.GET)
    public String listContacts(Map<String, Object> map) {
 
        map.put("department", new Department());
        map.put("departmentList", departmentService.list());
 
        return "department";
    }
    
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("department") @Valid Department department, BindingResult result) {

        if (result.hasErrors()) {
            return "department.save";
        }
        
        departmentService.insert(department);
 
        return "redirect:/department";
    }
    
    @RequestMapping(value = "/save", method= RequestMethod.GET)
    public String renderContact(Model model, @ModelAttribute Department department, WebRequest request) {
 
        return "department.save";
    }

    @RequestMapping(value="/save/{departmentId}", method = RequestMethod.GET)
    public String setupForm(@PathVariable("departmentId") Long departmentId, ModelMap model) {
        model.addAttribute("department", departmentService.getByID(departmentId));
        
        return "department.save";
    }

    @RequestMapping(value="/save/{departmentId}", method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("iddepartment") @Valid Department department, BindingResult result, SessionStatus status) {
        
        if (result.hasErrors()) {
            return "department.save";
        }
        
        departmentService.insert(department);
        status.setComplete();
        return "redirect:/department";
    }
    
    @RequestMapping("/delete/{departmentId}")
    public String deleteContact(@PathVariable("departmentId")
    Long departmentId) {
 
        departmentService.remove(departmentId);
 
        return "redirect:/department";
    }
}
