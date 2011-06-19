package net.kurochenko.ispub.department.dao;

import java.util.List;
import net.kurochenko.ispub.department.form.Department;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public interface DepartmentDAO {
    
    /**
     * Inserts new department. Departments ID should not be set. ID is set by
     * add method and indicates successful insertion of department.
     * 
     * @param department 
     */
    public void addDepartment(Department department);
    
    /**
     * Updates department information. Departments ID should be set. Department 
     * with same ID is updated.
     * 
     * @param department 
     */
    public void updateDepartment(Department department);
    
    /**
     * Returns all departments
     * 
     * @return 
     */
    public List<Department> listDepartment();
    
    /**
     * Removes department with specified ID if such department exists
     * 
     * @param id 
     */
    public void removeDepartment(Integer id);
}
