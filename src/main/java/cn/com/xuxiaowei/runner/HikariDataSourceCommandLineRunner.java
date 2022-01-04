package cn.com.xuxiaowei.runner;

import com.zaxxer.hikari.HikariDataSource;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * Hikari 初始化
 * <p>
 * 默认 Hikari 为懒加载
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@Component
public class HikariDataSourceCommandLineRunner implements CommandLineRunner {

    private HikariDataSource hikariDataSource;

    @Autowired
    public void setHikariDataSource(HikariDataSource hikariDataSource) {
        this.hikariDataSource = hikariDataSource;
    }

    @Override
    public void run(String... args) throws Exception {
        Connection connection = hikariDataSource.getConnection();

        Statement statement = connection.createStatement();
        ResultSet resultSet = statement.executeQuery("select 1.1 * 2.2");
        boolean next = resultSet.next();
        if (next) {
            BigDecimal bigDecimal = resultSet.getBigDecimal(1);
            log.info("Hikari 初始化完成：{}：{}", connection, bigDecimal);
        }

        // 关闭连接
        connection.close();
    }

}
