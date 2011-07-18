package net.kurochenko.ispub.author.service;

import java.util.List;
import net.kurochenko.ispub.author.dao.AuthorDAO;
import net.kurochenko.ispub.author.form.Author;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrej Kuročenko <kurochenko@gmail.com>
 */
@Service
@Transactional
public class AuthorServiceImpl implements AuthorService {
    
    @Autowired
    private AuthorDAO authorDAO;

    @Override
    public void saveAuthor(Author author) {
        authorDAO.insert(author);
    }

    @Override
    public void removeAuthor(Integer idAuthor) {
        authorDAO.remove(idAuthor);
    }

    @Override
    public Author getAuthorByID(Integer idAuthor) {
        return authorDAO.getByID(idAuthor);
    }

    @Override
    public List<Author> listAuthor() {
        return authorDAO.list();
    }

    @Override
    public void updateAuthor(Author author) {
        authorDAO.update(author);
    }
}
