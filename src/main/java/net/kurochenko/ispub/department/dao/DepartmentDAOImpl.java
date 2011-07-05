package net.kurochenko.ispub.department.dao;

import java.util.List;
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
@Repository
@Transactional
public class DepartmentDAOImpl implements DepartmentDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void saveDepartment(Department department) {
        sessionFactory.getCurrentSession().saveOrUpdate(department);
    }

    @Override
    public List<Department> listDepartment() {
        return sessionFactory.getCurrentSession().createQuery("from " + Department.class.getName()).list();
    }

    @Override
    public void removeDepartment(Integer id) {
        Department department = getDepartmentByID(id);
        if (null != department) {
            sessionFactory.getCurrentSession().delete(department);
        }
    }

    @Override
    public Department getDepartmentByID(Integer id) {
        return (Department) sessionFactory.getCurrentSession().get(Department.class, id);
    }

    @Override
    public Department getByName(String name) {

        Query query = sessionFactory.getCurrentSession().createQuery(
                "from " + Department.class.getName() + " where name=?");
        query.setString(0, name);

        return (Department) query.uniqueResult();
    }
    
}
