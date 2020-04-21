package com.chz.util;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.datasource.unpooled.UnpooledDataSourceFactory;

//实现dbcp连接池的类
public class DBCPDataSource extends UnpooledDataSourceFactory {

    public DBCPDataSource() {
        this.dataSource=new BasicDataSource();
    }
}
