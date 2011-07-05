package net.kurochenko.ispub.author.form;

import java.text.ParseException;
import java.util.Locale;
import net.kurochenko.ispub.author.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;


/**
 *
 * @author kurochenko
 */
@Component
public class AuthorFormatter implements Formatter<Author> {

    @Autowired
    private AuthorService authorService;
    
    @Override
    public String print(Author author, Locale locale) {
        return author.getName() + " " 
                + author.getSurname() 
                + " (" + author.getMeId() + ")" 
                + " [" + author.getIdAuthor() + "]";
    }

    @Override
    public Author parse(String string, Locale locale) throws ParseException {
        String [] credentials = string.split(" ");
        
        String meId = credentials[3].substring(1, credentials[3].length() - 1);
        
        return authorService.getAuthorByID(Integer.valueOf(meId));
    }
    
}
