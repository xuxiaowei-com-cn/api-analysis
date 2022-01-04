package cn.com.xuxiaowei.service.impl;

import cn.com.xuxiaowei.entity.TestMyBatisPlus;
import cn.com.xuxiaowei.mapper.TestMyBatisPlusMapper;
import cn.com.xuxiaowei.service.ITestMyBatisPlusService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 测试表 MyBatis Plus 服务实现类
 * </p>
 *
 * @author xuxiaowei
 */
@Service
public class TestMyBatisPlusServiceImpl extends ServiceImpl<TestMyBatisPlusMapper, TestMyBatisPlus> implements ITestMyBatisPlusService {

}
