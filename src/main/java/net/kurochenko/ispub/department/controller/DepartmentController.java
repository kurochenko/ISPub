package net.kurochenko.ispub.department.controller;

import java.util.Map;
import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * User: hbk
 * Date: 6/18/11
 * Time: 11:35 PM
 */
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
    
    @RequestMapping(value = "/department/add", method = RequestMethod.POST)
    public String addContact(@ModelAttribute("department")
    Department department, BindingResult result) {
 
        departmentService.addDepartment(department);
 
        return "redirect:/department";
    }
    
    @RequestMapping("/department/delete/{departmentId}")
    public String deleteContact(@PathVariable("departmentId")
    Integer departmentId) {
 
        departmentService.removeDepartment(departmentId);
 
        return "redirect:/department";
    }
}
