/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package net.kurochenko.ispub.department.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.sql.DataSource;
import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.utils.DBUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author kurochenko
 */
@Repository
public class DepartmentDAOJdbc implements DepartmentDAO {

    private static Logger logger = Logger.getLogger(DepartmentDAOJdbc.class);

    @Autowired
    private DataSource ds;
    
    @Override
    public void save(Department department) {
        if (department == null) {
            throw new IllegalArgumentException("Department is null");
        }
        
        Connection conn = null;

        try {
            conn = ds.getConnection();
            PreparedStatement st = conn.prepareStatement("INSERT INTO department "
                    + "(name) VALUES "
                    + "(?)",
                    Statement.RETURN_GENERATED_KEYS);

            st.setString(1, department.getName());
           

            int count = st.executeUpdate();
            department.setID(DBUtils.getId(st.getGeneratedKeys()));
            assert count == 1;
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Failed to add source", ex);
            throw new RuntimeException("Failed to add source", ex);
        } finally {
            DBUtils.closeConnection(conn);
        }
    }

    @Override
    public void trySave(Department department) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Department> list() {
        Connection conn = null;
        
        try {
            conn = ds.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM department");
            ResultSet rs = st.executeQuery();
            List<Department> found = new ArrayList<Department>();
            while(rs.next()) {
                found.add(rowToDepartment(rs));
            }
            return found;
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error when getting all department from DB",ex);
            throw new RuntimeException("Error when getting all department from DB",ex);
        } finally {
            DBUtils.closeConnection(conn);
        }
    }

    @Override
    public void remove(Long id) {
        Connection conn = null;
        
        try {
            conn = ds.getConnection();
            
            PreparedStatement stSD = conn.prepareStatement("DELETE * FROM author_department WHERE department=?");
            PreparedStatement stS = conn.prepareStatement("DELETE * FROM department WHERE iddepartment=?");
            
            stSD.setLong(1, id);
            stS.setLong(1, id);
            
            stSD.executeUpdate();
            stS.executeUpdate();
            
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error when removing department",ex);
            throw new RuntimeException("Error when removing department",ex);
        } finally {
            DBUtils.closeConnection(conn);
        }
    }

    @Override
    public Department getByID(Long id) {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "SELECT * FROM department WHERE iddepartment=?");
            st.setLong(1, id);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Department department = rowToDepartment(rs);
                assert !rs.next();
                return department;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error when getting department by ID from DB",ex);
            throw new RuntimeException("Error when getting department by ID from DB");
        } finally {
            DBUtils.closeConnection(conn);
        }
    }

    @Override
    public Department getByName(String name) {
        Connection conn = null;
        try {
            conn = ds.getConnection();
            PreparedStatement st = conn.prepareStatement(
                    "SELECT * FROM department WHERE name LIKE ?");
            st.setString(1, name);

            ResultSet rs = st.executeQuery();
            if (rs.next()) {
                Department department = rowToDepartment(rs);
                assert !rs.next();
                return department;
            } else {
                return null;
            }
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error when getting source by name from DB",ex);
            throw new RuntimeException("Error when getting source by name from DB");
        } finally {
            DBUtils.closeConnection(conn);
        }
    }
    
    private Department rowToDepartment(ResultSet rs) throws SQLException {
        if (rs == null) {
            throw new IllegalArgumentException("ResultSet is null");
        }
        Department department = new Department();
        department.setID(rs.getLong("iddepartment"));
        department.setName(rs.getString("name"));
        return department;
    }

    @Override
    public List<Department> getByAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author is null");
        }
        if (author.getId() == null) {
            throw new IllegalArgumentException("Author ID is null");
        }
        
        Connection conn = null;
        
        try {
            conn = ds.getConnection();
            PreparedStatement st = conn.prepareStatement("SELECT * FROM department "
                    + "WHERE iddepartment "
                    + "IN (SELECT iddepartment FROM author_department WHERE department=?)");
            st.setLong(1, author.getId());
            ResultSet rs = st.executeQuery();
            List<Department> found = new ArrayList<Department>();
            while(rs.next()) {
                found.add(rowToDepartment(rs));
            }
            return found;
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Error when getting departments for author from DB",ex);
            throw new RuntimeException("Error when getting departmentsfor author from DB",ex);
        } finally {
            DBUtils.closeConnection(conn);
        }
    }
    
}
