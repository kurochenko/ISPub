package net.kurochenko.ispub.author.form;

import java.beans.PropertyEditorSupport;
import net.kurochenko.ispub.author.dao.AuthorDAO;

/**
 *
 * @author kurochenko
 */
public class AuthorP extends PropertyEditorSupport {
    private AuthorDAO authorDAO;

    public void setDepartmentDAO(AuthorDAO authorDAO) {
        this.authorDAO = authorDAO;
    }

    @Override
    public void setAsText(String str) throws IllegalArgumentException {
        if (str != null && str.length() > 0) {
            try {
                Author author = this.authorDAO.getAuthorByID(Integer.valueOf(str));
                super.setValue(author);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
        } else {
            super.setValue(null);
        }
    }

    @Override
    public String getAsText() {
        Author author = (Author) super.getValue();
        return (author != null ? author.getIdAuthor().toString() : "");
    }
}
