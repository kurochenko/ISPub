package net.kurochenko.ispub;

import org.hibernate.dialect.MySQL5Dialect;

/**
 * User: kurochenko
 * Date: 7/10/11
 * Time: 3:12 PM
 */
public class MySQLMyISAMCzechDialect extends MySQL5Dialect {
    public String getTableTypeString() {
        return " ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_czech_ci";
    }
}
