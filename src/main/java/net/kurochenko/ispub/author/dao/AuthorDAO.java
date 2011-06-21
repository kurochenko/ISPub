package net.kurochenko.ispub.author.dao;

import java.util.List;
import net.kurochenko.ispub.author.form.Author;

/**
 *
 * @author Andrej Kuročenko <kurochenko@gmail.com>
 */
public interface AuthorDAO {
    public void saveAuthor(Author author);
    public void updateAuthor(Author author);
    public void removeAuthor(Integer idAuthor);
    public Author getAuthorByID(Integer idAuthor);
    public List<Author> listAuthor();
}
