package com.hlh.bug.service;

import com.baomidou.mybatisplus.service.IService;
import com.hlh.bug.entity.Bug;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author null123
 * @since 2020-01-02
 */
public interface BugService extends IService<Bug> {

    List<Bug> list(Bug bug);
}
