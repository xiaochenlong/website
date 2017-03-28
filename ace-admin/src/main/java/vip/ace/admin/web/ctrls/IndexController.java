package vip.ace.admin.web.ctrls;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xcl on 2017/3/22.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    @RequestMapping(value = {"/",""}, produces = {MediaType.TEXT_HTML_VALUE})
    public String index(Model model, HttpServletRequest request) {
        model.addAttribute("version", "1");
        return "index";
    }

    @RequestMapping(value = {"/admin"}, produces = {MediaType.TEXT_HTML_VALUE})
    public String admin(Model model, HttpServletRequest request) {
        model.addAttribute("version", "1");
        return "admin/index";
    }


    @RequestMapping(value = {"/version"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JSONObject test(HttpServletRequest request) {
        JSONObject data = new JSONObject();
        data.put("version", "1.2.0");
        data.put("admin", "xiao");
        return data;
    }
}
