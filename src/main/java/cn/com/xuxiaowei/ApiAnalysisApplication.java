package cn.com.xuxiaowei;

import com.p6spy.engine.spy.appender.P6Logger;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @see P6Logger
 * @see HikariDataSource
 */
@SpringBootApplication
public class ApiAnalysisApplication {

    public static void main(String[] args) {
        SpringApplication.run(ApiAnalysisApplication.class, args);
    }

}
