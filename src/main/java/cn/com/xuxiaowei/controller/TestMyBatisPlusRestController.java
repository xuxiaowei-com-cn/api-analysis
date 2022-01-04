package cn.com.xuxiaowei.controller;

import cn.com.xuxiaowei.entity.TestMyBatisPlus;
import cn.com.xuxiaowei.service.ITestMyBatisPlusBakService;
import cn.com.xuxiaowei.service.ITestMyBatisPlusService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试表 MyBatis Plus
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Slf4j
@RestController
@RequestMapping("/test/MyBatisPlus")
public class TestMyBatisPlusRestController {

    private ITestMyBatisPlusService testMyBatisPlusService;

    private ITestMyBatisPlusBakService testMyBatisPlusBakService;

    @Autowired
    public void setTestMyBatisPlusService(ITestMyBatisPlusService testMyBatisPlusService) {
        this.testMyBatisPlusService = testMyBatisPlusService;
    }

    @Autowired
    public void setTestMyBatisPlusBakService(ITestMyBatisPlusBakService testMyBatisPlusBakService) {
        this.testMyBatisPlusBakService = testMyBatisPlusBakService;
    }

    /**
     * 根据 ID 查询数据
     *
     * @param request  请求
     * @param response 响应
     * @param id       主键
     * @return 返回 执行结果
     */
    @RequestMapping("/getById")
    public Map<String, Object> getById(HttpServletRequest request, HttpServletResponse response, Long id) {

        Map<String, Object> map = new HashMap<>(4);

        TestMyBatisPlus byId = testMyBatisPlusService.getById(id);
        map.put("testMyBatisPlus", byId);

        TestMyBatisPlus byIdBak = testMyBatisPlusBakService.getById(id);
        map.put("testMyBatisPlusBak", byIdBak);

        return map;
    }

}
