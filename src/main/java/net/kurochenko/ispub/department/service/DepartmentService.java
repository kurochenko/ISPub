package net.kurochenko.ispub.department.service;

import java.util.List;
import net.kurochenko.ispub.department.form.Department;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
public interface DepartmentService {
/**
     * Inserts new department. If departments ID is not set then new department
     * is created. Otherwise department is updated according to its ID.
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
