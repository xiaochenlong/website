import org.junit.Test;
import vip.ace.sign.RSA;

import java.io.*;

/**
 * Created by xcl on 2017/5/6.
 * genrsa -out rsa_private_key.pem   1024
 * >openssl
 * OpenSSL> genrsa -out rsa_private_key.pem   1024  #生成私钥
 * OpenSSL> pkcs8 -topk8 -inform PEM -in rsa_private_key.pem -outform PEM -nocrypt -out rsa_private_key_pkcs8.pem #Java开发者需要将私钥转换成PKCS8格式
 * OpenSSL> rsa -in rsa_private_key.pem -pubout -out rsa_public_key.pem #生成公钥
 * OpenSSL> exit #退出OpenSSL程序
 */
public class RSA_TEST {


    private static String CHAR_SET = "UTF-8";


    public String loadFileContent(String filepath) throws IOException {
        File file = new File(filepath);
        String content = "";
        try (BufferedReader br = new BufferedReader(new FileReader(file))) {
            String tmp = null;
            while ((tmp = br.readLine()) != null) {
                content += tmp;
            }
        }
        return content;
    }

    @Test
    public void t1() throws Exception {
        //私钥字符串
        String privatekey = loadFileContent(RSA_TEST.class.getClassLoader().getResource("rsa_private_key_pkcs8.pem").getFile());
        privatekey = privatekey.replaceAll("-----BEGIN PRIVATE KEY-----", "");
        privatekey = privatekey.replaceAll("-----END PRIVATE KEY-----", "");

        //公钥字符串
        String publickey = loadFileContent(RSA_TEST.class.getClassLoader().getResource("rsa_public_key.pem").getFile());
        publickey = publickey.replaceAll("-----BEGIN PUBLIC KEY-----", "");
        publickey = publickey.replaceAll("-----END PUBLIC KEY-----", "");

        System.out.println(privatekey);
        System.out.println(publickey);


        //1.签名
        String sign = RSA.sign("1234", privatekey, CHAR_SET);
        System.out.println(sign);

        //签名验证
        boolean flag = RSA.verify("1234", sign, publickey, CHAR_SET);
        System.out.println(flag);


        // 3.公钥加密
        String pass = RSA.encrypt("aaa", publickey, CHAR_SET);
        System.out.println(pass);

        // 4.私钥解密
        String decript = RSA.decrypt(pass, privatekey, CHAR_SET);
        System.out.println(decript);

    }
}
