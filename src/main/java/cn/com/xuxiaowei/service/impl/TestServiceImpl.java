package cn.com.xuxiaowei.service.impl;

import cn.com.xuxiaowei.entity.Test;
import cn.com.xuxiaowei.mapper.TestMapper;
import cn.com.xuxiaowei.service.TestService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 测试表 Service 接口 实现类
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Service
public class TestServiceImpl implements TestService {

    @Resource
    private TestMapper testMapper;

    /**
     * 根据 ID 查询数据
     *
     * @param id 主键
     * @return 返回 查询的数据
     */
    @Override
    public Test getById(Long id) {
        return testMapper.getById(id);
    }

}
