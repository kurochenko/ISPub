package net.kurochenko.ispub.source.form;

import net.kurochenko.ispub.author.form.Author;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import org.hibernate.annotations.Cascade;

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 1:19 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
@Table(name = "source")
public class Source implements Serializable {
    @Id
    @Column(name = "sourceId")
    @GeneratedValue
    Integer sourceId;

    @Column(name = "name",unique = true)
    String name;

    @ManyToMany(mappedBy = "sources")
            @JoinTable(name = "author_source",
        joinColumns = { @JoinColumn(name = "source")},
        inverseJoinColumns = { @JoinColumn(name = "author")})
    Set<Author> authors = new HashSet<Author>();

    public Source() {}

    public Source(String name) {
        this.name = name;
    }

    public Integer getSourceId() {
        return sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
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
    
    public void addAuthor(Author author) {
        this.authors.add(author);
        author.getSources().add(this);
    }
    
    public void removeAuthor(Author author) {
        this.authors.remove(author);
        author.getSources().remove(this);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Source source = (Source) o;

        if (name != null ? !name.equals(source.name) : source.name != null) return false;
        if (sourceId != null ? !sourceId.equals(source.sourceId) : source.sourceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sourceId != null ? sourceId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return name;
    }
}
