package com.mysql_.数据库连接池;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import com.mchange.v2.c3p0.DataSources;
import org.junit.jupiter.api.Test;

public class C3P0 {
    @Test
    public void testGet() throws Exception{

        ComboPooledDataSource cpds = new ComboPooledDataSource();
        cpds.setDriverClass( "com.mysql.cj.jdbc.Driver" ); //loads the jdbc driver
        cpds.setJdbcUrl( "jdbc:mysql://localhost:3306/test?characterEncoding=utf8&useSSL=false&serverTimezone=UTC&rewriteBatchedStatements=true" );
        cpds.setUser("root");
        cpds.setPassword("1234567890Qq");

        cpds.setInitialPoolSize(10);

        System.out.println(cpds.getConnection());
        DataSources.destroy(cpds);
    }
}
