package transfer;

import org.apache.ibatis.type.BaseTypeHandler;
import org.apache.ibatis.type.JdbcType;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/**
 *实现转换器1.implements TypeHandler 2.extends BaseTypeHandler<?>
 */
public class TypeTransfer extends BaseTypeHandler<Boolean> {

    /**
     *
     *        set java to db
     *        get db to java
     *        需要配置到config文件中
     * @param preparedStatement
     * @param i 操作参数的位置
     * @param aBoolean java的值
     * @param jdbcType sql的值
     * @throws SQLException
     */
    @Override
    public void setNonNullParameter(PreparedStatement preparedStatement, int i, Boolean aBoolean, JdbcType jdbcType) throws SQLException {
        if (aBoolean){
            //如果是true就是女
            preparedStatement.setObject(i,1);
        }else{
            //如果是false就是男
            preparedStatement.setObject(i,0);
        }

    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, String s) throws SQLException {
//        return (Integer) resultSet.getObject(s)==1?true:false;
        return (Integer) resultSet.getObject(s) == 1;
    }

    @Override
    public Boolean getNullableResult(ResultSet resultSet, int i) throws SQLException {
        return (Integer) resultSet.getObject(i) == 1;

    }

    @Override
    public Boolean getNullableResult(CallableStatement callableStatement, int i) throws SQLException {
        return null;
    }
}
