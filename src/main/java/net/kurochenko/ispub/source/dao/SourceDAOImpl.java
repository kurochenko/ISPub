package net.kurochenko.ispub.source.dao;

import net.kurochenko.ispub.source.form.Source;
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
@Repository
@Transactional
public class SourceDAOImpl implements SourceDAO {

    @Autowired
    SessionFactory sessionFactory;

    @Override
    public void saveSource(Source source) {
        sessionFactory.getCurrentSession().saveOrUpdate(source);
    }

    @Override
    public void removeSource(Integer id) {
        Source source = getByID(id);
        if (source != null) {
            sessionFactory.getCurrentSession().delete(source);
        }
    }

    @Override
    public Source getByID(Integer id) {
        return (Source) sessionFactory.getCurrentSession().get(Source.class, id);
    }

    @Override
    public List<Source> list() {
        return (List<Source>) sessionFactory.getCurrentSession().createQuery("from " + Source.class.getName()).list();
    }
}