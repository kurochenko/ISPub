package net.kurochenko.ispub.department.dao;

import java.util.List;
import net.kurochenko.ispub.department.form.Department;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public interface DepartmentDAO {
    
    /**
     * Inserts new department. If departments ID is set, then department in 
     * database is updated. Otherwise new department is created.
     * 
     * @param department 
     */
    public void saveDepartment(Department department);
    
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
    
    /**
     * Searches and returns department with given ID
     * 
     * @param id
     * @return department from 
     */
    public Department getDepartmentByID(Integer id);
}
