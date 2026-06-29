package com.alexis.apigateway.config;

import org.springframework.cloud.gateway.server.mvc.filter.LoadBalancerFilterFunctions;
import org.springframework.cloud.gateway.server.mvc.handler.HandlerFunctions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.function.RequestPredicates;
import org.springframework.web.servlet.function.RouterFunction;
import org.springframework.web.servlet.function.RouterFunctions;
import org.springframework.web.servlet.function.ServerResponse;

@Configuration
public class GatewayConfig {

    @Bean
    public RouterFunction<ServerResponse> productRoutes() {
        return RouterFunctions.route(
                RequestPredicates.path("/api/products/**"),
                HandlerFunctions.http())
                .filter(LoadBalancerFilterFunctions.lb("PRODUCT-SERVICE"));
    }

    @Bean
    public RouterFunction<ServerResponse> orderRoutes() {
        return RouterFunctions.route(
                RequestPredicates.path("/api/orders/**"),
                HandlerFunctions.http())
                .filter(LoadBalancerFilterFunctions.lb("ORDER-SERVICE"));
    }

    @Bean
    public RouterFunction<ServerResponse> userRoutes() {
        return RouterFunctions.route(
                RequestPredicates.path("/api/users/**"),
                HandlerFunctions.http())
                .filter(LoadBalancerFilterFunctions.lb("USER-SERVICE"));
    }
}