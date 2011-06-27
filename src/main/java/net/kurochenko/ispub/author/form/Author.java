package net.kurochenko.ispub.author.form;

import java.io.Serializable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import net.kurochenko.ispub.department.form.Department;



/**
 *
 * @author Andrej Kuročenko <kurochenko@gmail.com>
 */
@Entity
@Table(name = "author")
public class Author implements Serializable {

    @Id
    @Column(name = "idauthor")
    @GeneratedValue
    private Integer idAuthor;
    
    @Column(name = "me_id")
    private String meId;

    @Column(name = "name")
    private String name;
    
    @Column(name = "surname")
    private String surname;
    
    @Column(name = "note")
    private String note;

    @ManyToOne(cascade = CascadeType.ALL)
    private Department department;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public Integer getIdAuthor() {
        return idAuthor;
    }

    public void setIdAuthor(Integer idAuthor) {
        this.idAuthor = idAuthor;
    }

    public String getMeId() {
        return meId;
    }

    public void setMeId(String meId) {
        this.meId = meId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Author other = (Author) obj;
        if (this.idAuthor != other.idAuthor && (this.idAuthor == null || !this.idAuthor.equals(other.idAuthor))) {
            return false;
        }
        if ((this.meId == null) ? (other.meId != null) : !this.meId.equals(other.meId)) {
            return false;
        }
        if ((this.name == null) ? (other.name != null) : !this.name.equals(other.name)) {
            return false;
        }
        if ((this.surname == null) ? (other.surname != null) : !this.surname.equals(other.surname)) {
            return false;
        }
        if ((this.note == null) ? (other.note != null) : !this.note.equals(other.note)) {
            return false;
        }
        if (this.department != other.department && (this.department == null || !this.department.equals(other.department))) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + (this.idAuthor != null ? this.idAuthor.hashCode() : 0);
        hash = 41 * hash + (this.meId != null ? this.meId.hashCode() : 0);
        hash = 41 * hash + (this.name != null ? this.name.hashCode() : 0);
        hash = 41 * hash + (this.surname != null ? this.surname.hashCode() : 0);
        hash = 41 * hash + (this.note != null ? this.note.hashCode() : 0);
        hash = 41 * hash + (this.department != null ? this.department.hashCode() : 0);
        return hash;
    }

    @Override
    public String toString() {
        return "Author{" + "name=" + name + ", surname=" + surname + '}';
    }
}
