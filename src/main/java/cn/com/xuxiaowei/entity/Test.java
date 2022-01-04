package cn.com.xuxiaowei.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 测试表
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
public class Test implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    private Long id;

    /**
     * 用户名，唯一键：uk_test__username
     */
    private String username;

    /**
     * 密码，不为空
     */
    private String password;

    /**
     * 备注
     */
    private String remark;

    /**
     * 创建时间，不为空
     */
    private LocalDateTime createDate;

    /**
     * 更新时间，未更新时为空
     */
    private LocalDateTime updateDate;

    /**
     * 创建人，不为空
     */
    private String createUsername;

    /**
     * 更新人，未更新时为空
     */
    private String updateUsername;

    /**
     * 创建者IP，不为空
     */
    private String createIp;

    /**
     * 更新者IP，未更新时为空
     */
    private String updateIp;

    /**
     * 逻辑删除，0 未删除，1 删除，MySQL 默认值 0，不为 NULL
     */
    private Boolean deleted;

}
