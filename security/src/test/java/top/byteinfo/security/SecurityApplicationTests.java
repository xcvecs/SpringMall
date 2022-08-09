package top.byteinfo.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SecurityApplicationTests {
    @Data
    @AllArgsConstructor
    class User {
        String username;
        String password;
    }

    @Data
    @AllArgsConstructor
    class Admin{
        String username;
        String password;
    }
    @Test
    void contextLoads() throws IOException {

        User user = new User("user", "user");

        ObjectMapper objectMapper =new ObjectMapper();

        byte[] bytes = objectMapper.writeValueAsBytes(user);

        Admin admin = objectMapper.readValue(bytes, Admin.class);

        System.out.println();
    }

}
