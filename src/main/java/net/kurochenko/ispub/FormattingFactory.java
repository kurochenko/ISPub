package net.kurochenko.ispub;

import net.kurochenko.ispub.author.form.AuthorAnnotationFormatterFactory;
import net.kurochenko.ispub.department.form.DepartmentAnnotationFormatterFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;
import org.springframework.stereotype.Component;

/**
 *
 * @author kurochenko
 */
@Component
public class FormattingFactory extends FormattingConversionServiceFactoryBean {

    @Autowired
    AuthorAnnotationFormatterFactory authorFactory;

    @Autowired
    DepartmentAnnotationFormatterFactory departmentFactory;

    @Override
    public void installFormatters(FormatterRegistry registry) {
        super.installFormatters(registry);
//        registry.addFormatterForFieldType(Author.class, new AuthorFormatter());
//        registry.addFormatterForFieldType(Department.class, new DepartmentFormatter());

        if (authorFactory == null) {
            throw new IllegalStateException("author factory is null");
        }

        if (departmentFactory == null) {
            throw new IllegalStateException("department factory is null");
        }

        registry.addFormatterForFieldAnnotation(authorFactory);
        registry.addFormatterForFieldAnnotation(departmentFactory);
    }
    
}

