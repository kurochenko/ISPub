package net.kurochenko.ispub.department.form;

import java.beans.PropertyEditorSupport;
import net.kurochenko.ispub.department.dao.DepartmentDAO;

/**
 *
 * @author kurochenko
 */
public class DepartmentEditor extends PropertyEditorSupport {

    private DepartmentDAO departmentDAO;

    public void setDepartmentDAO(DepartmentDAO departmentDAO) {
        this.departmentDAO = departmentDAO;
    }

    @Override
    public void setAsText(String str) throws IllegalArgumentException {
        if (str != null && str.length() > 0) {
            try {
                Department department = this.departmentDAO.getDepartmentByID(Integer.valueOf(str));
                super.setValue(department);
            } catch (NumberFormatException ex) {
                throw new IllegalArgumentException();
            }
        } else {
            super.setValue(null);
        }
    }

    @Override
    public String getAsText() {
        Department department = (Department) super.getValue();
        return (department != null ? department.getIddepartment().toString() : "");
    }
}
