package com.hlh.bug.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hlh.bug.entity.Bug;
import com.hlh.bug.entity.ResMsg;
import com.hlh.bug.service.BugService;
import com.hlh.bug.util.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/bug")
public class BugController {

    @Autowired
    private BugService bugService;

    /**
     * API(GET): /bug/list
     * 获取待我审批列表
     * pageNum: 分页页码
     * pageSize: 分页条数
     * dutyName: 责任人姓名
     * createName: 创建人姓名
     * type: 类型 1 已解决  0 未解决
     */
    @GetMapping("/list")
    public ResMsg list(Bug bug, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "10")int pageSize) {
        PageHelper.startPage(pageNum, pageSize);

        if (StringUtil.isBlank(bug.getSort())) {
            bug.setSort("desc");
        }
        List<Bug> result = bugService.list(bug);
        for (int i = 0; i < result.size(); i++) {
            Bug t =  result.get(i);
            t.setSortNum((pageNum-1) * pageSize + i + 1); // 设置序号，用户前端展示
        }
        PageInfo<Bug> info = new PageInfo<>(result);

        return new ResMsg(200, "成功", info);
    }

    /**
     * API(GET): /bug/getById
     * id: 记录id
     */
    @GetMapping("/getById")
    public ResMsg getById(Integer id) {
        if (id == null) {
            return new ResMsg(1, "记录id为空");
        }
        return new ResMsg(200, "成功", bugService.selectById(id));
    }

    /**
     * API(POST): /bug/save
     * 添加bug
     * pageNum: 分页页码
     * pageSize: 分页条数
     * dutyName: 责任人姓名
     * desc: 描述
     * opinion: 处理意见
     * createName: 创建人姓名
     * type: 类型 1 已解决  0 未解决
     */
    @PostMapping("/save")
    public ResMsg save(Bug bug) {
        bug.setDate(new Date());
        bugService.insert(bug);
        return new ResMsg(200, "添加成功");
    }

    /**
     * API(POST): /bug/update
     * 修改
     * pageNum: 分页页码
     * pageSize: 分页条数
     * dutyName: 责任人姓名
     * desc: 描述
     * opinion: 处理意见
     * createName: 创建人姓名
     * type: 类型 1 已解决  0 未解决
     * id: 必传
     */
    @PostMapping("/update")
    public ResMsg update(Bug bug) {

        if (bug.getId() == null) {
            return new ResMsg(1, "记录id为空");
        }

        bugService.updateById(bug);

        return new ResMsg(200, "修改成功");
    }


}
