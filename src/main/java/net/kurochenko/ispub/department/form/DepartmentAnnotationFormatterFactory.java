package net.kurochenko.ispub.department.form;

import java.util.HashSet;
import java.util.Set;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

/**
 *
 * @author kurochenko
 */
public final class DepartmentAnnotationFormatterFactory implements 
        AnnotationFormatterFactory<DepartmentFormat> {

    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(Department.class);
        return set;
    }

    @Override
    public Printer<Department> getPrinter(DepartmentFormat a, Class<?> type) {
        return new DepartmentFormatter();
    }

    @Override
    public Parser<Department> getParser(DepartmentFormat a, Class<?> type) {
        return new DepartmentFormatter();
    }
    
}
