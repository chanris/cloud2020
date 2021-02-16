package com.atguigu.springcloud;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;
import java.sql.SQLException;

/**
 * @author chenyue7@foxmail.com
 * @date 2021/2/11
 *
 * 注意:SpringBoot测试类要和boot启动类的包一样或者子包。
 */
@SpringBootTest
public class DataSourceTests {

    @Autowired
    DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println(dataSource);
        System.out.println(dataSource.getConnection());
    }
}
