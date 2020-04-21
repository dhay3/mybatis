package db;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

public class BDCPDataSource extends UnpooledDataSourceFactory {
    public BDCPDataSource() {
        this.dataSource=new BasicDataSource();
    }
}
