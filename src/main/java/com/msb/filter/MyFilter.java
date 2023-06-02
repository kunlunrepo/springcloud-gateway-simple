package com.msb.filter;

import com.msb.GatewaySimple;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

/**
 * description : 自定义全局过滤器
 * @author kunlunrepo
 * date :  2023-06-02 17:26
 */
@Component
public class MyFilter implements Ordered, GlobalFilter {

    private static final Logger log = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String username = exchange.getRequest().getQueryParams().getFirst("username");
        if (username == null) {
            log.info("**********非法用户**********");
            exchange.getResponse().setStatusCode(HttpStatus.NOT_ACCEPTABLE);
            return exchange.getResponse().setComplete(); // 打断过滤器链
        }
        return chain.filter(exchange);
    }

    /**
     * 加载过滤器的顺序(整数数字越小优先级越高)
     */
    @Override
    public int getOrder() {
        return 0;
    }
}
