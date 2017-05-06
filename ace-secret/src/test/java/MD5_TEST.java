import org.junit.Test;
import vip.ace.sign.MD5;

/**
 * Created by xcl on 2017/5/6.
 */
public class MD5_TEST {

    private static String CHAR_SET = "UTF-8";

    @Test
    public void t1(){
        String pass = MD5.sign("xiao","11111111AAAAAAAAAAAAAAAAAAAFFFFF4444444444",CHAR_SET);
        System.out.println(pass);
        boolean flag = MD5.verify("xiao1",pass, "1", CHAR_SET);
        System.out.println(flag);
    }
}
