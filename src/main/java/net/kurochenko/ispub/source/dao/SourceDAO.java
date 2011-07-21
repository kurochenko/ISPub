package net.kurochenko.ispub.source.dao;

import net.kurochenko.ispub.source.form.Source;

import java.util.List;
import net.kurochenko.ispub.author.form.Author;

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SourceDAO {
    public void insert(Source source);

    public void remove(Long sourceID);

    public Source getByID(Long sourceID);
    
    public List<Source> getByAuthor(Author author);

    public Source getByName(String name);

    public List<Source> list();

    public void insertAuthorSources(Author author);
}
