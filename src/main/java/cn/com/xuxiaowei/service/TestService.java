package cn.com.xuxiaowei.service;

import cn.com.xuxiaowei.entity.Test;

/**
 * 测试表 Service 接口
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public interface TestService {

    /**
     * 根据 ID 查询数据
     *
     * @param id 主键
     * @return 返回 查询的数据
     */
    Test getById(Long id);

}
