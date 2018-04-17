package com.logmaster.handler;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.Maps;
import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

/**
 * @author wanglu
 * @Description:
 * @Date: 2017/10/16.
 */
public class JsonTypeHandler extends BaseTypeHandler<Map<?, ?>> {
    private static final Logger logger = LoggerFactory.getLogger(JsonTypeHandler.class);
    private ObjectMapper objectMapper = new ObjectMapper();

    @Override
    public void setNonNullParameter(PreparedStatement ps, int idx,
                                    Map<?, ?> parameter, JdbcType jdbcType)
            throws SQLException {
        String parameterValue = null;
        try {
            parameterValue = objectMapper.writeValueAsString(parameter);
        } catch (JsonProcessingException e) {
            logger.error("JsonTypeHandler error", e);
        }
        ps.setString(idx, parameterValue);
    }

    @Override
    public Map<?, ?> getNullableResult(ResultSet rs, String columnName)
            throws SQLException {
        String columnValue = rs.getString(columnName);
        Map<String, Object> result = Maps.newHashMap();
        try {
            result = objectMapper.readValue(columnValue, result.getClass());
        } catch (IOException e) {
            logger.error("JsonTypeHandler error", e);
        }
        return result;
    }

    @Override
    public Map<?, ?> getNullableResult(ResultSet rs, int columnIndex) throws SQLException {
        String columnValue = rs.getString(columnIndex);
        Map<String, Object> result = Maps.newHashMap();
        try {
            result = objectMapper.readValue(columnValue, result.getClass());
        } catch (IOException e) {
            logger.error("JsonTypeHandler error", e);
        }
        return result;
    }

    @Override
    public Map<?, ?> getNullableResult(CallableStatement cs, int columnIndex)
            throws SQLException {
        String columnValue = cs.getString(columnIndex);
        Map<String, Object> result = Maps.newHashMap();
        try {
            result = objectMapper.readValue(columnValue, result.getClass());
        } catch (IOException e) {
            logger.error("JsonTypeHandler error", e);
        }
        return result;
    }
}
