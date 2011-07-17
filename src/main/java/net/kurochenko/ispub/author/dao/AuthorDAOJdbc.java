package net.kurochenko.ispub.author.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;
import javax.annotation.Resource;
import javax.sql.DataSource;
import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.utils.DBUtils;
import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
@Repository
public class AuthorDAOJdbc implements AuthorDAO {
    
    private static Logger logger = Logger.getLogger(AuthorDAOJdbc.class);
    
    @Resource(name = "jdbc/bis")
    private DataSource ds;

    @Override
    public void saveAuthor(Author author) {
        if (author == null) {
            throw new IllegalArgumentException("Author is null");
        }
        if (author.getIdAuthor() != null) {
            throw new IllegalArgumentException("Authors ID is set. You may want to update.");
        }
        
        Connection conn = null;

        try {
            conn = ds.getConnection();
            PreparedStatement stmt = conn.prepareStatement("INSERT INTO author "
                    + "(me_id, name, surname, note) VALUES "
                    + "(?,?,?,?)");

            stmt.setString(1, author.getMeId());
            stmt.setString(2, author.getName());
            stmt.setString(3, author.getSurname());
            stmt.setString(4, author.getNote());
           

            int count = stmt.executeUpdate();
            assert count == 1;
        } catch (SQLException ex) {
            logger.log(Level.ERROR, "Failed to add Author", ex);
            throw new RuntimeException("Failed to add Author", ex);
        } finally {
            DBUtils.closeConnection(conn);
        }
    }

    @Override
    public void updateAuthor(Author author) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void removeAuthor(Integer idAuthor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Author getAuthorByID(Integer idAuthor) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public List<Author> listAuthor() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
    
}
