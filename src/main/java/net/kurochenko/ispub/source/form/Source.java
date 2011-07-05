package net.kurochenko.ispub.source.form;

import net.kurochenko.ispub.author.form.Author;

import javax.annotation.Generated;
import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

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

    @Column(name = "name")
    String name;

    @ManyToMany(
            targetEntity = Author.class,
            mappedBy = "sources",
            cascade = {CascadeType.PERSIST, CascadeType.MERGE}
    )
    Set<Author> authors;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Source source = (Source) o;

        if (authors != null ? !authors.equals(source.authors) : source.authors != null) return false;
        if (name != null ? !name.equals(source.name) : source.name != null) return false;
        if (sourceId != null ? !sourceId.equals(source.sourceId) : source.sourceId != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = sourceId != null ? sourceId.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (authors != null ? authors.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Source{" +
                "sourceId=" + sourceId +
                ", name='" + name + '\'' +
                '}';
    }
}