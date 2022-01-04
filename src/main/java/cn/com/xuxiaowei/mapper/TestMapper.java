package cn.com.xuxiaowei.mapper;

import cn.com.xuxiaowei.entity.Test;
import org.apache.ibatis.annotations.Param;

/**
 * 测试表 Mapper 接口
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
public interface TestMapper {

    /**
     * 根据 ID 查询数据
     *
     * @param id 主键
     * @return 返回 查询的数据
     */
    Test getById(@Param("id") Long id);

}
