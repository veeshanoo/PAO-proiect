package pao.database.sqlite.dao.converter;

import java.sql.ResultSet;

public interface Converter<T> {
    T convert(ResultSet rs);
}
