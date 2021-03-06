package com.ttms.web;

import com.ttms.pojo.PageBean;
import com.ttms.pojo.State;
import com.ttms.pojo.Studio;
import com.ttms.service.StudioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by IntelliJ IDEA.
 * User: kevin
 * Date: 2018/6/11
 */
@Controller
@RequestMapping("/studio")
public class StudioController {
    @Autowired
    private StudioService studioService;

    @RequestMapping(value = "/list")
    @ResponseBody
    public List list() {
        List<Studio> list = studioService.getList();
        return list;
    }

    //条件查找
    @RequestMapping(value = "/tt")
    @ResponseBody
    public Map getByCondition(Studio studio) {
        System.out.println(studio);
        List<Studio> list = studioService.getListByCondition(studio);
        Map map = new HashMap();
        map.put("rows", list);
        int total = studioService.getByConditionCount(studio);
        map.put("total", total);
        return map;
    }

    @RequestMapping("/page")
    @ResponseBody
    public Map studioPage(HttpServletRequest request) {
        int currentPage = Integer.parseInt(request.getParameter("page"));
        int pageSize = Integer.parseInt(request.getParameter("rows"));
        HashMap<String, Object> map = new HashMap<>();
        PageBean<Studio> pageBean = studioService.getPagebean(currentPage, pageSize);
        map.put("rows", pageBean.getList());
        map.put("total", pageBean.getTotalCount());
        return map;
    }

    @RequestMapping("/add")
    @ResponseBody
    public State addStudio(Studio studio) {
        try {
            studioService.addStudio(studio);
            return new State(true, "添加成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "添加失败");
    }

    @RequestMapping("/update")
    @ResponseBody
    public State updateStudio(Studio studio) {
        try {
            studioService.updateStudio(studio);
            return new State(true, "更新成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "更新失败");
    }

    @RequestMapping("/delete")
    @ResponseBody
    public State deleteStudio(String id) {
        try {
            studioService.deleteStudio(id);
            return new State(true, "删除成功");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new State(false, "删除失败");
    }
}
