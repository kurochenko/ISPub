package net.kurochenko.ispub.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * User: hbk
 * Date: 6/18/11
 * Time: 11:35 PM
 */
@Controller
public class DepartmentController {
    @RequestMapping("/department")
    public ModelAndView renderDepartment() {
        String msg = "Hello, department!";
        return new ModelAndView("department", "hellomsg", msg);
    }
}
