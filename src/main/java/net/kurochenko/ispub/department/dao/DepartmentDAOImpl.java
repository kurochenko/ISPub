package net.kurochenko.ispub.department.dao;

import java.util.List;

import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.department.form.Department;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
//@Repository
//@Transactional
public class DepartmentDAOImpl implements DepartmentDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void save(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    @Override
    public void trySave(Department department) {

        Department dep;

        if (department == null || ((dep = getByName(department.getName())) == null)) {
            save(department);
        } else {
            department = dep;
        }

    }

    @Override
    public List<Department> list() {
        return sessionFactory.getCurrentSession().createQuery("from " + Department.class.getName()).list();
    }

    @Override
    public void remove(Long id) {

        Query query = sessionFactory.getCurrentSession().createQuery("update " + Author.class.getName()
                + " set department = null where department = ?");
        query.setLong(0, id);
        query.executeUpdate();

        Department department = getByID(id);
        if (null != department) {
            sessionFactory.getCurrentSession().delete(department);
        }
    }

    @Override
    public Department getByID(Long id) {
        return (Department) sessionFactory.getCurrentSession().get(Department.class, id);
    }

    @Override
    public Department getByName(String name) {

        Query query = sessionFactory.getCurrentSession().createQuery(
                "from " + Department.class.getName() + " where name=?");
        query.setString(0, name);

        return (Department) query.uniqueResult();
    }

    @Override
    public List<Department> getByAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
