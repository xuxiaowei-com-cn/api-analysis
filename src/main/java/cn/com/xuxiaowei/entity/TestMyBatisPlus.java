package cn.com.xuxiaowei.entity;

import com.baomidou.mybatisplus.annotation.*;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 测试表 MyBatis Plus
 *
 * @author xuxiaowei
 * @since 0.0.1
 */
@Data
@TableName("test")
public class TestMyBatisPlus implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键，自增
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名，唯一键：uk_test__username
     */
    @TableField("username")
    private String username;

    /**
     * 密码，不为空
     */
    @TableField("password")
    private String password;

    /**
     * 备注
     */
    @TableField("remark")
    private String remark;

    /**
     * 创建时间，不为空
     */
    @TableField("create_date")
    private LocalDateTime createDate;

    /**
     * 更新时间，未更新时为空
     */
    @TableField("update_date")
    private LocalDateTime updateDate;

    /**
     * 创建人，不为空
     */
    @TableField("create_username")
    private String createUsername;

    /**
     * 更新人，未更新时为空
     */
    @TableField("update_username")
    private String updateUsername;

    /**
     * 创建者IP，不为空
     */
    @TableField("create_ip")
    private String createIp;

    /**
     * 更新者IP，未更新时为空
     */
    @TableField("update_ip")
    private String updateIp;

    /**
     * 逻辑删除，0 未删除，1 删除，MySQL 默认值 0，不为 NULL
     */
    @TableLogic
    @TableField("deleted")
    private Boolean deleted;

}
