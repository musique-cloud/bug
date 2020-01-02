package com.hlh.bug.entity;

import java.util.Date;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.enums.IdType;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author null123
 * @since 2020-01-02
 */
@Data
public class Bug implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(type=IdType.AUTO)
    private Integer id;
    /**
     * bug描述
     */
    private String desc;
    /**
     * 处理意见
     */
    private String opinion;
    /**
     * 指定要处理bug的人的姓名
     */
    @TableField("duty_name")
    private String dutyName;
    /**
     * 发起人的名字
     */
    @TableField("create_name")
    private String createName;
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date date;
    /**
     * 1 已处理  0 未解决
     */
    private String type;

    @TableField(exist = false)
    private String sort;

    @TableField(exist = false)
    private int sortNum;

}
