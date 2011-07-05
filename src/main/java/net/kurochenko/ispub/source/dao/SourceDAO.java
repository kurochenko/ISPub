package net.kurochenko.ispub.source.dao;

import net.kurochenko.ispub.source.form.Source;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 1:38 PM
 * To change this template use File | Settings | File Templates.
 */
public interface SourceDAO {
    public void saveSource(Source source);

    public void removeSource(Integer id);

    public Source getByID(Integer id);

    public List<Source> list();
}
