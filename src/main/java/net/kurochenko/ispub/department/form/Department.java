package net.kurochenko.ispub.department.form;

import net.kurochenko.ispub.author.form.Author;

import java.io.Serializable;
import java.util.Set;
import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.NotBlank;

/**
 *
 * @author Andrej Kuročenko <kurochenko@mail.muni.cz>
 */
@Entity
@Table(name="department")
public class Department implements Serializable {
    
    @Id
    @Column(name="iddepartment")
    @GeneratedValue
    private Long id;
    
    @Column(name="name", unique=true)
    @NotNull
    @NotBlank
    @Max(255)
    private String name;

    @ManyToMany(mappedBy = "departments")
    private Set<Author> authors;

    public Department() {}

    public Department(String name) {
        this.name = name;
    }

    public Long getID() {
        return id;
    }

    public void setID(Long iddepartment) {
        this.id = iddepartment;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(Set<Author> authors) {
        this.authors = authors;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Department other = (Department) obj;
        if (this.id != other.id && (this.id == null || !this.id.equals(other.id))) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 11 * hash + (this.id != null ? this.id.hashCode() : 0);
        hash = 11 * hash + (this.name != null ? this.name.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Department{" + "name=" + name + '}';
    }
}
