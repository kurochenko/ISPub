package net.kurochenko.ispub.source.service;

import net.kurochenko.ispub.source.dao.SourceDAO;
import net.kurochenko.ispub.source.form.Source;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 1:48 PM
 * To change this template use File | Settings | File Templates.
 */

@Service
@Transactional
public class SourceServiceImpl implements SourceService {

    @Autowired
    SourceDAO sourceDAO;

    @Override
    public void saveSource(Source source) {
        sourceDAO.insert(source);
    }

    @Override
    public void removeSource(Integer id) {
        sourceDAO.remove(null);
    }

    @Override
    public Source getByID(Integer id) {
        return sourceDAO.getByID(null);
    }

    @Override
    public Source getByName(String name) {
        return sourceDAO.getByName(name);
    }

    @Override
    public List<Source> list() {
        return sourceDAO.list();
    }
}
