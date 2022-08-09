package top.byteinfo.springmall;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;

@SpringBootTest
class SpringMallApplicationTests {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
  static   class User {
        String username;
        String password;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
  static   class Admin{
        String username;
        String password;
        @JsonIgnore
        String passwords;
    }
    @Test
    void contextLoads() throws IOException {

        User user = new User("user", "user");

        ObjectMapper objectMapper =new ObjectMapper();

//        byte[] bytes = objectMapper.writeValueAsBytes(user);
        String bytes = objectMapper.writeValueAsString(user);

        User admin = objectMapper.readValue(bytes, User.class);
        Admin admins = objectMapper.readValue(bytes, Admin.class);

        System.out.println();
    }

}
