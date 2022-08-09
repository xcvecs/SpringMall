package com.example.demo;

import io.debezium.connector.mysql.MySqlConnector;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
    MySqlConnector mySqlConnector;
    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }

}
