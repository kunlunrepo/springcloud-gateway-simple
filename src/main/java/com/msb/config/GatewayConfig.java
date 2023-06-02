package com.msb.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * description : 网关配置
 * @author kunlunrepo
 * date :  2023-06-02 16:05
 */
@Configuration
public class GatewayConfig {

    // 动态配置路由规则
//    @Bean
    public RouteLocator testRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        // 构建多个路由routes
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        // 具体路由规则
        routes.route(
                "path_msb", // 服务id
                r -> r.path("/api/v1/**") // 匹配路径
                        .uri("http://localhost:19999") // 路由到的地址
                ).build();
        // 返回
        return routes.build();
    }

}
