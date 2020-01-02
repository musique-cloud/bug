package com.hlh.bug.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 前台返回结果封装类
 */
@Data
public class ResMsg implements Serializable {

    private static final long serialVersionUID = -6741284181417364169L;

    /** 返回码 */
    private Integer code;

    /** 返回信息 */
    private String msg;

    /** 数据 */
    private Object data;

    public ResMsg(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResMsg(Integer code, String msg, Object data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    @Override
    public String toString() {
        return "ResMsg [code=" + code + ", msg=" + msg + ", data=" + data + "]";
    }

}
