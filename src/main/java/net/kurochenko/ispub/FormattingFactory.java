package net.kurochenko.ispub;

import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.author.form.AuthorFormatter;
import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.department.form.DepartmentFormatter;
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
        registry.addFormatterForFieldType(Author.class, new AuthorFormatter());
        registry.addFormatterForFieldType(Department.class, new DepartmentFormatter());
    }
    
}
