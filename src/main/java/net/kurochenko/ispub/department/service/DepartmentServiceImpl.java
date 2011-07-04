package net.kurochenko.ispub.department.service;

import java.util.List;
import net.kurochenko.ispub.department.dao.DepartmentDAO;
import net.kurochenko.ispub.department.form.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public void saveDepartment(Department department) {
        departmentDAO.saveDepartment(department);
    }

    @Override
    public List<Department> listDepartment() {
        return departmentDAO.listDepartment();
    }

    @Override
    public void removeDepartment(Integer id) {
        departmentDAO.removeDepartment(id);
    }

    @Override
    public Department getDepartmentByID(Integer id) {
        return departmentDAO.getDepartmentByID(id);
    }

    @Override
    public Department getByName(String name) {
        return departmentDAO.getByName(name);
    }
    
}
