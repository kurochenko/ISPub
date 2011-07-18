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
@Transactional
public class DepartmentServiceImpl implements DepartmentService {
    
    @Autowired
    private DepartmentDAO departmentDAO;

    @Override
    public void insert(Department department) {
        departmentDAO.save(department);
    }

    @Override
    public void trySave(Department department) {
        departmentDAO.trySave(department);
    }

    @Override
    public List<Department> list() {
        return departmentDAO.list();
    }

    @Override
    public void remove(Long id) {
        departmentDAO.remove(id);
    }

    @Override
    public Department getByID(Long id) {
        return departmentDAO.getByID(id);
    }

    @Override
    public Department getByName(String name) {
        return departmentDAO.getByName(name);
    }
    
}
