package com.msb;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class GatewaySimple {

    private static final Logger log = LoggerFactory.getLogger(GatewaySimple.class);

    public static void main(String[] args) {
        log.info("【网关服务启动中...】");
        SpringApplication.run(GatewaySimple.class, args);
        log.info("【网关服务启动完成】");
    }

}