package net.kurochenko.ispub.source.dao;

import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.source.form.Source;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 1:42 PM
 * To change this template use File | Settings | File Templates.
 */
//@Repository
//@Transactional
public class SourceDAOImpl implements SourceDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void insert(Source source) {
//        sessionFactory.getCurrentSession().saveOrUpdate(source);
        Source src = getByName(source.getName());
        if (src == null) {
            sessionFactory.getCurrentSession().saveOrUpdate(source);
        } else {
            source.setId(src.getId());
        }

    }

    @Override
    public void remove(Long sourceID) {
        Source source = getByID(null);
        if (source != null) {
//            for (Author author : source.getAuthors()) {
//                author.getSources().clear();
//            }
            sessionFactory.getCurrentSession().delete(source);
        }
    }

    @Override
    public Source getByID(Long sourceID) {
        return (Source) sessionFactory.getCurrentSession().get(Source.class, sourceID);
    }

    @Override
    public Source getByName(String name) {
        Query query = sessionFactory.getCurrentSession().createQuery(
                "from " + Source.class.getName() + " where name=?");
        query.setString(0, name);

        return (Source) query.uniqueResult();
    }

    @Override
    public List<Source> list() {
        return (List<Source>) sessionFactory.getCurrentSession().createQuery("from " + Source.class.getName()).list();
    }

    @Override
    public void insertAuthorSources(Author author) {
        //To change body of implemented methods use File | Settings | File Templates.
    }

    @Override
    public List<Source> getByAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
