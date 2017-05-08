package com.db;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * @author Fang Yong (fangyong02@baidu.com)
 */
public abstract class DbCodeEnumTypeHandler<E extends Enum & CodeEnum> extends BaseTypeHandler<E> {
    private final Class<E> enumClass;

    public DbCodeEnumTypeHandler(Class<E> enumClass) {
        this.enumClass = enumClass;
    }

    @Override
    public void setNonNullParameter(PreparedStatement ps, int i, E parameter, JdbcType jdbcType) throws SQLException {
        ps.setInt(i, parameter.getCode());
    }

    @Override
    public E getNullableResult(ResultSet rs, String columnName) throws SQLException {
        return CodeEnumUtils.parse(enumClass, rs.getInt(columnName));
    }

    @Override
    public E getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        return CodeEnumUtils.parse(enumClass, rs.getInt(columnIndex));
    }

    @Override
    public E getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        return CodeEnumUtils.parse(enumClass, cs.getInt(columnIndex));
    }
}
