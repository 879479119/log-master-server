package com.logmaster.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Lists;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/16.
 */
public class ListTypeHandler extends BaseTypeHandler<List<?>> {
    private ObjectMapper objectMapper = new ObjectMapper();
    private static final Logger logger = LoggerFactory.getLogger(ListTypeHandler.class);

    @Override
    public void setNonNullParameter(PreparedStatement ps, int index, List<?> parameter,
                                    JdbcType jdbcType) throws SQLException {
        String paramStr = null;
        try {
            paramStr = objectMapper.writeValueAsString(parameter);
        } catch (JsonProcessingException e) {
            logger.error("Error while write {} as string!", parameter, e);
        }
        ps.setString(index, paramStr);
    }

    @Override
    public List<?> getNullableResult(ResultSet rs, String columnName) throws SQLException {
        List<Object> result = Lists.newArrayList();
        try {
            result = objectMapper.readValue(rs.getString(columnName), result.getClass());
        } catch (IOException e) {
            //pass
        }
        return result;
    }

    @Override
    public List<?> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        List<Object> result = Lists.newArrayList();
        try {
            result = objectMapper.readValue(rs.getString(columnIndex), result.getClass());
        } catch (IOException e) {
            //pass
        }
        return result;
    }

    @Override
    public List<?> getNullableResult(CallableStatement cs, int columnIndex) throws SQLException {
        List<Object> result = Lists.newArrayList();
        try {
            result = objectMapper.readValue(cs.getString(columnIndex), result.getClass());
        } catch (IOException e) {
            //pass
        }
        return result;
    }
}
