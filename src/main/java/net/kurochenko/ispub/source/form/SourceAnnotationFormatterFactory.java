package net.kurochenko.ispub.source.form;

import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.department.form.DepartmentFormat;
import net.kurochenko.ispub.department.form.DepartmentFormatter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 7:49 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public final class SourceAnnotationFormatterFactory implements AnnotationFormatterFactory<SourceFormat> {

    @Autowired
    SourceFormatter sourceFormatter;

    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(Source.class);
        return set;
    }

    @Override
    public Printer<Source> getPrinter(SourceFormat a, Class<?> type) {
        return sourceFormatter;
    }

    @Override
    public Parser<Source> getParser(SourceFormat a, Class<?> type) {
        return sourceFormatter;
    }
}
