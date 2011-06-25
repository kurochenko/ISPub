package net.kurochenko.ispub.author.form;

import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import java.util.Locale;
import net.kurochenko.ispub.author.dao.AuthorDAO;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import static org.junit.Assert.*;

/**
 *
 * @author kurochenko
 */
//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration( locations = { "classpath:spring-servlet.xml" })
public class AuthorFormatterTest {
    
    private Formatter<Author> formatter;
    
    @Autowired
    private AuthorDAO authorDAO;
    
    public AuthorFormatterTest() {
    }

    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }
    
    @Before
    public void setUp() {
        formatter = new AuthorFormatter();
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of print method, of class AuthorFormatter.
     */
    @Test
    public void testPrint() {
//        Author author = new Author();
//        author.setIdAuthor(55);
//        author.setMeId("JBoss");
//        author.setName("John");
//        author.setSurname("Boss");
//        
//        assertEquals("John Boss (JBoss) [55]", formatter.print(author, Locale.ENGLISH));
    }

    /**
     * Test of parse method, of class AuthorFormatter.
     */
    @Test
    public void testParse() throws Exception {
//        Author author = new Author();
//        author.setMeId("JBoss");
//        author.setName("John");
//        author.setSurname("Boss");
//        
//        authorDAO.saveAuthor(author);
//        
//        assertEquals(author, formatter.parse("John Boss (JBoss) [" + author.getIdAuthor() + "]", Locale.ENGLISH));
    }
}
