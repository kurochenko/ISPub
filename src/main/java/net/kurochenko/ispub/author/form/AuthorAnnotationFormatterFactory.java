package net.kurochenko.ispub.author.form;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;
import org.springframework.stereotype.Component;

/**
 *
 * @author kurochenko
 */
@Component
public final class AuthorAnnotationFormatterFactory implements 
        AnnotationFormatterFactory<AuthorFormat> {

    @Autowired
    AuthorFormatter authorFormatter;

    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(Author.class);
        return set;
    }

    @Override
    public Printer<Author> getPrinter(AuthorFormat a, Class<?> type) {
        return authorFormatter;
    }

    @Override
    public Parser<Author> getParser(AuthorFormat a, Class<?> type) {
        return authorFormatter;
    }    
}
