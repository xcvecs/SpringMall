package top.byteinfo.springmall.web;

import lombok.Data;
import org.apache.commons.beanutils.MethodUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationTargetException;

@SpringBootTest
public class SpringMallWebApplicationTest {

    @Data
    static class User {
        String username;
        String password;
    }

    @Data
    class Admin {
        String adminname;
        String username;
        String password;
    }

    @Test
    void t1() throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {


        Admin admin = new Admin();


    }


    static class Demo {
        public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, IllegalAccessException {
            User user = new User();
            user.setUsername("success");

            Object method = MethodUtils.invokeMethod(user, "getUsername", null);

            System.out.println();
        }

    }

}
