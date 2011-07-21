package net.kurochenko.ispub.source.service;

import net.kurochenko.ispub.author.form.Author;
import net.kurochenko.ispub.source.form.Source;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 1:47 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SourceService {

    public void saveSource(Source source);

    public void removeSource(Integer id);

    public Source getByID(Integer id);

    public Source getByName(String name);

    public List<Source> list();

    public void insertAuthorSources(Author author);
}
