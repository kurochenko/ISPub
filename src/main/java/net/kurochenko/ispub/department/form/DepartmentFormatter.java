package net.kurochenko.ispub.department.form;

import java.text.ParseException;
import java.util.Locale;
import net.kurochenko.ispub.department.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;


/**
 *
 * @author kurochenko
 */
@Component
public class DepartmentFormatter implements Formatter<Department> {

    @Autowired
    private DepartmentService departmentService;
    
    @Override
    public String print(Department department, Locale locale) {
        return department.getName();
    }

    @Override
    public Department parse(String string, Locale locale) throws ParseException {
        return departmentService.getByName(string);
    }
}
