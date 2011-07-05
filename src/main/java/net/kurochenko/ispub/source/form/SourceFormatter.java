package net.kurochenko.ispub.source.form;

import net.kurochenko.ispub.department.service.DepartmentService;
import net.kurochenko.ispub.source.form.Source;
import net.kurochenko.ispub.source.service.SourceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

/**
 * Created by IntelliJ IDEA.
 * User: kurochenko
 * Date: 7/5/11
 * Time: 7:43 PM
 * To change this template use File | Settings | File Templates.
 */
@Component
public class SourceFormatter implements Formatter<Source> {

    @Autowired
    private SourceService sourceService;

    @Override
    public Source parse(String s, Locale locale) throws ParseException {
        return sourceService.getByName(s);
    }

    @Override
    public String print(Source source, Locale locale) {
        return source.getName();
    }
}
