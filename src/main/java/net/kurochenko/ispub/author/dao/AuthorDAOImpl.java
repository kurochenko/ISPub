package net.kurochenko.ispub.author.dao;

import java.util.List;
import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.source.form.Source;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrej Kuročenko <kurochenko@gmail.com>
 */
//@Repository
//@Transactional
public class AuthorDAOImpl implements AuthorDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Author author) {
        sessionFactory.getCurrentSession().saveOrUpdate(author);
    }

    @Override
    public void remove(Integer idAuthor) {
        Author author = getByID(idAuthor);
        if (null != author) {

//            author.getSources().clear();


            sessionFactory.getCurrentSession().delete(author);
        }
    }

    @Override
    public Author getByID(Integer idAuthor) {
        return (Author) sessionFactory.getCurrentSession().get(Author.class, idAuthor);
    }

    @Override
    public List<Author> list() {
        return sessionFactory.getCurrentSession().createQuery("from " + Author.class.getName()).list();
    }

    @Override
    public void update(Author author) {
        sessionFactory.getCurrentSession().update(author);
    }
}
