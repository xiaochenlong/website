import org.springframework.web.client.RestTemplate;

import java.util.Objects;


/**
 * Created by xcl on 2017/3/28.
 */
public class test {

    public static void main(String[] args) {
        RestTemplate rt = new RestTemplate();
        Object obj = rt.getForObject("http://127.0.0.1:8002/version", Object.class);
        System.out.println(obj);
    }
}
