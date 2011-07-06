package net.kurochenko.ispub;

import net.kurochenko.ispub.author.form.AuthorAnnotationFormatterFactory;
import net.kurochenko.ispub.department.form.DepartmentAnnotationFormatterFactory;
import net.kurochenko.ispub.source.form.SourceAnnotationFormatterFactory;
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

    @Autowired
    SourceAnnotationFormatterFactory sourceFactory;

    @Override
    public void installFormatters(FormatterRegistry registry) {
        super.installFormatters(registry);

        registry.addFormatterForFieldAnnotation(authorFactory);
        registry.addFormatterForFieldAnnotation(departmentFactory);
        registry.addFormatterForFieldAnnotation(sourceFactory);
    }
    
}

