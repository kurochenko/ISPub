package net.kurochenko.ispub;

import net.kurochenko.ispub.author.form.AuthorAnnotationFormatterFactory;
import net.kurochenko.ispub.department.form.DepartmentAnnotationFormatterFactory;
import org.springframework.format.FormatterRegistry;
import org.springframework.format.support.FormattingConversionServiceFactoryBean;

/**
 *
 * @author kurochenko
 */
public class FormattingFactory extends FormattingConversionServiceFactoryBean {
    
    @Override
    public void installFormatters(FormatterRegistry registry) {
        super.installFormatters(registry);
//        registry.addFormatterForFieldType(Author.class, new AuthorFormatter());
//        registry.addFormatterForFieldType(Department.class, new DepartmentFormatter());
        registry.addFormatterForFieldAnnotation(new AuthorAnnotationFormatterFactory());
        registry.addFormatterForFieldAnnotation(new DepartmentAnnotationFormatterFactory());
    }
    
}

