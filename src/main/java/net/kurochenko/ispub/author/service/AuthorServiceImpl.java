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
        authorDAO.saveAuthor(author);
    }

    @Override
    public void removeAuthor(Integer idAuthor) {
        authorDAO.removeAuthor(idAuthor);
    }

    @Override
    public Author getAuthorByID(Integer idAuthor) {
        return authorDAO.getAuthorByID(idAuthor);
    }

    @Override
    public List<Author> listAuthor() {
        return authorDAO.listAuthor();
    }

    @Override
    public void updateAuthor(Author author) {
        authorDAO.updateAuthor(author);
    }
}
