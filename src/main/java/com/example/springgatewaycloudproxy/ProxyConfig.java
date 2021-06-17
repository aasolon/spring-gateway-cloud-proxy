package com.example.springgatewaycloudproxy;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ProxyConfig {

    @Bean
    public RouteLocator myRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route(p -> p
                        .path("/download-file")
                        .filters(f -> {
                            return f.addRequestHeader("Hello", "World");
                        })
                        .uri("http://localhost:8081/download-file"))
                .build();
    }
}
