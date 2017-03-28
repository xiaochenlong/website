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
@RequestMapping("/admin")
public class AdminController {



    @RequestMapping(value = {"/login"}, produces = {MediaType.TEXT_HTML_VALUE})
    public String login(Model model, HttpServletRequest request) {
        return "admin/login";
    }

}
