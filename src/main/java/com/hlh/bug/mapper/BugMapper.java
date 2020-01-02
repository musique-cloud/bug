package com.hlh.bug.mapper;


import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.hlh.bug.entity.Bug;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author null123
 * @since 2020-01-02
 */
public interface BugMapper extends BaseMapper<Bug> {

    List<Bug> list(Bug bug);
}
