package top.byteinfo.springmall.web.config.redis;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

@Component
public class RedisClient {
    @Autowired
    RedisTemplate redisTemplate;


}
