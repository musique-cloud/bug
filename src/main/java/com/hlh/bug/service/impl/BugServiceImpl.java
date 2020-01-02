package com.hlh.bug.service.impl;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.hlh.bug.entity.Bug;
import com.hlh.bug.mapper.BugMapper;
import com.hlh.bug.service.BugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author null123
 * @since 2020-01-02
 */
@Service
public class BugServiceImpl extends ServiceImpl<BugMapper, Bug> implements BugService {

    @Autowired
    private BugMapper bugMapper;

    @Override
    public List<Bug> list(Bug bug) {
        return bugMapper.list(bug);
    }
}
