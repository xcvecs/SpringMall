package top.byteinfo.springmall.web.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import top.byteinfo.springmall.web.config.redis.RedisClient;
import top.byteinfo.springmall.web.service.SpringService;
//@Service
public class SpringServiceImpl implements SpringService {
    @Autowired
    RedisClient redisClient;

    public void redisGeneralCode(){

    }




}
