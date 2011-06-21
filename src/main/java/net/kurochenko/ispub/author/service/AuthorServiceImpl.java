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
public class AuthorServiceImpl implements AuthorService {
    
    @Autowired
    private AuthorDAO authorDAO;

    @Override
    @Transactional
    public void saveAuthor(Author author) {
        authorDAO.saveAuthor(author);
    }

    @Override
    @Transactional
    public void removeAuthor(Integer idAuthor) {
        authorDAO.removeAuthor(idAuthor);
    }

    @Override
    @Transactional
    public Author getAuthorByID(Integer idAuthor) {
        return authorDAO.getAuthorByID(idAuthor);
    }

    @Override
    @Transactional
    public List<Author> listAuthor() {
        return authorDAO.listAuthor();
    }

    @Override
    public void updateAuthor(Author author) {
        authorDAO.updateAuthor(author);
    }
    
}
