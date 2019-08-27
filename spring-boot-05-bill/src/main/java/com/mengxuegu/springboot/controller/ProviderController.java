package com.mengxuegu.springboot.controller;

import com.mengxuegu.springboot.dao.ProviderDao;
import com.mengxuegu.springboot.entities.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Map;

/**
 * 供应商的控制层
 * @Author: hasee
 */
@Controller
public class ProviderController {
    Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    ProviderDao providerDao;

    /**
     * 查询所有供应商
     * @param map
     * @param providerName
     * @RequestParam(value = "providerName",required = false) 不是必须参数
     * @return
     */
    @GetMapping(value = "/providers")
    public String list(Map<String,Object> map,
                       @RequestParam(value = "providerName",required = false) String providerName){
        logger.info("供应商查询。。"+providerName);
        Collection<Provider> providers = providerDao.getAll(providerName);
        map.put("providers",providers);
        map.put("providerName",providerName); //用于回显搜索框
        return "provider/list";
    }

    /**
     * 查询指定供应商
     *  type默认为view，
     *  type=null进入provider下的view.html页面
     *  type=update进入provider下的update.html页面
     * @param pid
     * @param type
     * @param map
     * @return
     */
    @GetMapping("/provider/{pid}")
    public String view(@PathVariable(value = "pid") Integer pid,
                       @RequestParam(value = "type",defaultValue = "view") String type,
                       Map<String,Object> map){
        logger.info("查询pid："+pid+"供应商的详情");
        Provider provider = providerDao.getProvider(pid);
        map.put("provider",provider);
        return "provider/"+type;
    }

    /**
     * 更新供应商
     * @param provider
     * @return
     */
    @PutMapping("/provider")
    public String update(Provider provider){
        logger.info("更新供应商..");
        providerDao.save(provider);
        return "redirect:/providers";
    }

    /**
     * 进入供应商添加页面
     * @return
     */
    @GetMapping("/provider")
    public String toAddPage(){
        return "provider/add";
    }

    /**
     * 添加供应商
     * @param provider
     * @return
     */
    @PostMapping("/provider")
    public String addProvider(Provider provider){
        logger.info("添加供应商："+provider);
        providerDao.save(provider);
        return "redirect:/providers";
    }

    /**
     * 删除供应商
     * @param pid
     * @return
     */
    @DeleteMapping("/provider/{pid}")
    public String delete(@PathVariable(value = "pid") Integer pid){
        logger.info("删除供应商:"+pid);
        providerDao.delete(pid);
        logger.info("删除成功");
        return "redirect:/providers";
    }
}
