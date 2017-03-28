package vip.ace.front.web.ctrls;

import com.alibaba.fastjson.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import vip.ace.front.result.ResultBody;
import vip.ace.front.result.ResultInfoException;
import vip.ace.front.result.ReusltInfoEnum;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by xcl on 2017/3/22.
 */
@Controller
@RequestMapping("/")
public class IndexController {

    /**
     * 模版返回
     *
     * @param model
     * @param request
     * @return
     */
    @RequestMapping(value = {"/", ""}, produces = {MediaType.TEXT_HTML_VALUE})
    public String list(Model model, HttpServletRequest request) {
        model.addAttribute("version", "1");
        return "index";
    }


    /**
     * json返回（1）
     *
     * @param request
     * @return
     */
    @RequestMapping(value = {"/version"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public JSONObject test(HttpServletRequest request) {
        JSONObject data = new JSONObject();
        data.put("version", "1.2.0");
        return data;
    }

    /**
     * json返回（2）
     *
     * @param request
     * @return
     */
    @RequestMapping(value = {"/result"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResultBody result(HttpServletRequest request) {
        JSONObject data = new JSONObject();
        data.put("name", "xiao");
        data.put("city", "笑");
        return new ResultBody(data);
    }

    /**
     * 异常处理
     *
     * @param request
     * @return
     * @throws ResultInfoException
     */
    @RequestMapping(value = {"/exception"}, produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseBody
    public ResultBody exception(HttpServletRequest request) throws ResultInfoException {
        try {
            ServletRequestUtils.getRequiredIntParameter(request, "i");
        } catch (Exception e) {
            throw new ResultInfoException(ReusltInfoEnum.NOT_FOUND);
        }
        JSONObject data = new JSONObject();
        data.put("name", "xiao");
        return new ResultBody(data);
    }

}
