package net.kurochenko.ispub.department.form;

import java.beans.PropertyEditorSupport;
import net.kurochenko.ispub.department.service.DepartmentService;

/**
 *
 * @author kurochenko
 */
public class DepartmentP extends PropertyEditorSupport {

    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }
    
    public DepartmentP(DepartmentService ds) {
        this.departmentService = ds;
    }

    @Override
    public void setAsText(String str) throws IllegalArgumentException {
        if (str != null && str.length() > 0) {
            try {
                Department department = this.departmentService.getDepartmentByID(Integer.valueOf(str));
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
