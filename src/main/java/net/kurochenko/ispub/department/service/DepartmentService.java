package net.kurochenko.ispub.department.service;

import java.util.List;
import net.kurochenko.ispub.department.form.Department;
import org.springframework.stereotype.Service;

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
    public void insert(Department department);
    public void trySave(Department department);
    
    /**
     * Returns all departments
     * 
     * @return 
     */
    public List<Department> list();
    
    /**
     * Removes department with specified ID if such department exists
     * 
     * @param id 
     */
    public void remove(Long id);    
    
    /**
     * Searches and returns department with given ID
     * 
     * @param id
     * @return department from 
     */
    public Department getByID(Long id);
    
    /**
     * Searches and returns department with given name
     * 
     * @param name
     * @return department from 
     */
    public Department getByName(String name);
}
