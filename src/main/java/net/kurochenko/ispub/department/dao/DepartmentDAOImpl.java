package net.kurochenko.ispub.department.dao;

import java.util.List;
import net.kurochenko.ispub.department.form.Department;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
@Repository
public class DepartmentDAOImpl implements DepartmentDAO {
    
    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void addDepartment(Department department) {
        sessionFactory.getCurrentSession().save(department);
    }

    @Override
    public void updateDepartment(Department department) {
        sessionFactory.getCurrentSession().update(department);
    }

    @Override
    public List<Department> listDepartment() {
        return sessionFactory.getCurrentSession().createQuery("from Department").list();
    }

    @Override
    public void removeDepartment(Integer id) {
        Department department = (Department) sessionFactory.getCurrentSession().load(
                Department.class, id);
        if (null != department) {
            sessionFactory.getCurrentSession().delete(department);
        }
    }
    
}
