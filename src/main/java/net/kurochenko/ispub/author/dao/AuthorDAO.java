package net.kurochenko.ispub.author.dao;

import java.util.List;
import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.source.form.Source;

/**
 *
 * @author Andrej Kuročenko <kurochenko@gmail.com>
 */
public interface AuthorDAO {
    public void insert(Author author);
    public void update(Author author);
    public void remove(Integer idAuthor);
    public Author getByID(Integer idAuthor);
    public List<Author> list();
}
