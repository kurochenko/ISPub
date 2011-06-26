package net.kurochenko.ispub.author.form;

import java.util.HashSet;
import java.util.Set;
import org.springframework.format.AnnotationFormatterFactory;
import org.springframework.format.Parser;
import org.springframework.format.Printer;

/**
 *
 * @author kurochenko
 */
public final class AuthorAnnotationFormatterFactory implements 
        AnnotationFormatterFactory<AuthorFormat> {

    @Override
    public Set<Class<?>> getFieldTypes() {
        Set<Class<?>> set = new HashSet<Class<?>>();
        set.add(Author.class);
        return set;
    }

    @Override
    public Printer<Author> getPrinter(AuthorFormat a, Class<?> type) {
        return new AuthorFormatter();
    }

    @Override
    public Parser<Author> getParser(AuthorFormat a, Class<?> type) {
        return new AuthorFormatter();
    }    
}
