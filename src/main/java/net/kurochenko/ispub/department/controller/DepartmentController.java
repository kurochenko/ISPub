package net.kurochenko.ispub.department.controller;

import java.util.Map;
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
import org.springframework.web.servlet.ModelAndView;

@Controller
public class DepartmentController {
    
    @Autowired
    private DepartmentService departmentService;
    
    @RequestMapping("/department")
    public String listContacts(Map<String, Object> map) {
 
        map.put("department", new Department());
        map.put("departmentList", departmentService.listDepartment());
 
        return "department";
    }
    
    @RequestMapping(value = "**/save", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("department")
    Department department, BindingResult result) {
 
        departmentService.saveDepartment(department);
 
        return "redirect:/department";
    }
    
    @RequestMapping(value = "**/save", method= RequestMethod.GET)
    public String renderContact(Model model, @ModelAttribute Department department, WebRequest request) {
 
        return "department.save";
    }
    
    @RequestMapping("**/delete/{departmentId}")
    public String deleteContact(@PathVariable("departmentId")
    Integer departmentId) {
 
        departmentService.removeDepartment(departmentId);
 
        return "redirect:/department";
    }
    
    @RequestMapping(value = "**/update/{departmentId}", method= RequestMethod.GET)
    public ModelAndView updateContact(@PathVariable("departmentId") Integer departmentId) {
        
        return new ModelAndView("department.update", "department", departmentService.getDepartmentByID(departmentId));
    }

    @RequestMapping(value="**/save/{departmentId}", method = RequestMethod.GET)
    public String setupForm(@PathVariable("departmentId") Integer departmentId, ModelMap model) {
        model.addAttribute("department", departmentService.getDepartmentByID(departmentId));
        
        return "department.save";
    }

    @RequestMapping(value="**/save/{departmentId}", method = RequestMethod.POST)
    public String processSubmit(@ModelAttribute("iddepartment") Department department, BindingResult result, SessionStatus status) {
        departmentService.saveDepartment(department);
        status.setComplete();
        return "redirect:/department";
    }
}
