package cn.com.xuxiaowei.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;

/**
 * 主页
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
public class IndexRestController {

    private DataSource dataSource;

    @Autowired
    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    /**
     * 主页
     *
     * @param request  请求
     * @param response 响应
     * @return 返回 执行结果
     */
    @RequestMapping
    public Map<String, Object> index(HttpServletRequest request, HttpServletResponse response) {

        Map<String, Object> map = new HashMap<>(4);

        try {
            Connection connection = dataSource.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select 2 * 3");
            boolean next = resultSet.next();
            if (next) {
                map.put("result", resultSet.getInt(1));
                map.put("msg", "执行成功");
            } else {
                map.put("msg", "执行成功，但无返回值");
            }
        } catch (SQLException e) {
            log.error("执行失败：", e);
            map.put("msg", e);
        }

        return map;
    }

}
