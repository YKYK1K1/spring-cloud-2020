package com.yky.spring.cloud.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @version 1.0
 * @ClassName GateWayConfig
 * @Description TODO
 * @Author YKY
 * @Date 2020/12/17 13:33
 **/
@Configuration
public class GateWayConfig {

    /**
     * 配置了一个 id 为 route-name 的路由规则，
     * 当访问地址 http://localhost:9527/guonei 时会自动转发到地址: http://news.baidu.com/guonei
     *
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_route yky",
                r -> r.path("/guonei")
                        .uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }
}
