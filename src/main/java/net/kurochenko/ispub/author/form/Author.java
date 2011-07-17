package net.kurochenko.ispub.author.form;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import net.kurochenko.ispub.department.form.Department;
import net.kurochenko.ispub.department.form.DepartmentFormat;
import net.kurochenko.ispub.source.form.Source;
import net.kurochenko.ispub.source.form.SourceFormat;
import org.hibernate.annotations.Cascade;


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

    @DepartmentFormat
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE, CascadeType.REFRESH}, fetch = FetchType.EAGER)
    @JoinColumn(name = "iddepartment", nullable = true)
    private Department department;

    @SourceFormat
    @ManyToMany(fetch= FetchType.EAGER)
    @JoinTable(name = "author_source",
        joinColumns = { @JoinColumn(name = "author")},
        inverseJoinColumns = { @JoinColumn(name = "source")})
    private Set<Source> sources = new HashSet<Source>();

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

    public Set<Source> getSources() {
        return sources;
    }

    public void setSources(Set<Source> sources) {
        this.sources = sources;
    }
    
    public void addSource(Source source) {
        this.sources.add(source);
        source.getAuthors().add(this);
    }
    
    public void removeSource(Source source) {
        this.sources.remove(source);
        source.getAuthors().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Author author = (Author) o;

        if (idAuthor != null ? !idAuthor.equals(author.idAuthor) : author.idAuthor != null) return false;
        if (meId != null ? !meId.equals(author.meId) : author.meId != null) return false;
        if (name != null ? !name.equals(author.name) : author.name != null) return false;
        if (note != null ? !note.equals(author.note) : author.note != null) return false;
        if (surname != null ? !surname.equals(author.surname) : author.surname != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = idAuthor != null ? idAuthor.hashCode() : 0;
        result = 31 * result + (meId != null ? meId.hashCode() : 0);
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (note != null ? note.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Author{" + "name=" + name + ", surname=" + surname + '}';
    }
}
