package vip.ace.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by xcl on 2017/3/22.
 */
@SpringBootApplication
@MapperScan("vip.ace.admin.dao")
@EnableTransactionManagement
public class Admin implements CommandLineRunner {


    @Override
    public void run(String... args) throws Exception {
    }

    public static void main(String[] args) {
        SpringApplication.run(Admin.class,args);

    }


}
