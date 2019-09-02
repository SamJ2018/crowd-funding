package com.cys.crowdfunding.manager.controller;

import com.cys.crowdfunding.manager.service.UserService;
import com.cys.crowdfunding.utils.AjaxResult;
import com.cys.crowdfunding.utils.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sam
 * @apiNote
 * @since 2019-09-02-21:04
 **/
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping("/toIndex")
    public String toIndex() {
        return "user/index";
    }


    /**
     * 同步请求，废弃！
     *
     * @param pageno
     * @param pagesize
     * @param model
     * @return
     */
    //@RequestMapping("/index")
    public String index(@RequestParam(value = "pageno", required = false, defaultValue = "1") Integer pageno,
                        @RequestParam(value = "pagesize", required = false, defaultValue = "10") Integer pagesize,
                        Model model) {
        Page page = userService.queryPage(pageno, pagesize);
        model.addAttribute("page", page);
        return "user/index3";
    }

    @ResponseBody
    @RequestMapping("index")
    public Object indexAsyn(@RequestParam(value = "pageno", required = false, defaultValue = "1") Integer pageno,
                            @RequestParam(value = "pagesize", required = false, defaultValue = "10") Integer pagesize) {
        AjaxResult result = new AjaxResult();
        Page page = userService.queryPage(pageno, pagesize);
        if (page != null) {
            result.setSuccess(true);
            result.setPage(page);
        } else {
            result.setMessage("用户为空");
            result.setSuccess(false);
        }
        return result;
    }
}
