package net.kurochenko.ispub.department.service;

import java.util.List;
import net.kurochenko.ispub.department.dao.DepartmentDAO;
import net.kurochenko.ispub.department.form.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
@Service
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    @Transactional
    public void addDepartment(Department department) {
        departmentDAO.addDepartment(department);
    }

    @Override
    @Transactional
    public void updateDepartment(Department department) {
        departmentDAO.updateDepartment(department);
    }

    @Override
    @Transactional
    public List<Department> listDepartment() {
        return departmentDAO.listDepartment();
    }

    @Override
    @Transactional
    public void removeDepartment(Integer id) {
        departmentDAO.removeDepartment(id);
    }
    
}
