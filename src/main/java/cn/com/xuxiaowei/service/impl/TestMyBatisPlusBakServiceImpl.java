package cn.com.xuxiaowei.service.impl;

import cn.com.xuxiaowei.entity.TestMyBatisPlus;
import cn.com.xuxiaowei.mapper.TestMyBatisPlusMapper;
import cn.com.xuxiaowei.service.ITestMyBatisPlusBakService;
import cn.com.xuxiaowei.service.ITestMyBatisPlusService;
import com.baomidou.dynamic.datasource.annotation.DS;
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
@DS("master_bak")
public class TestMyBatisPlusBakServiceImpl extends ServiceImpl<TestMyBatisPlusMapper, TestMyBatisPlus> implements ITestMyBatisPlusBakService {

}
