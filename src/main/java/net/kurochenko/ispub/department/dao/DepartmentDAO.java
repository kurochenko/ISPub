package net.kurochenko.ispub.department.dao;

import java.util.List;
import net.kurochenko.ispub.author.form.Author;
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
    public void save(Department department);

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
    
    public List<Department> getByAuthor(Author author);
    
    /**
     * Searches and returns department with given name
     * 
     * @param name
     * @return department from 
     */
    public Department getByName(String name);
}
