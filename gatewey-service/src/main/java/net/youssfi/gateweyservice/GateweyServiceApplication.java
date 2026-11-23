package net.youssfi.gateweyservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;

@SpringBootApplication
public class GateweyServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GateweyServiceApplication.class, args);
    }

    @Bean
    RouteLocator staticRoutes(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("customers", r -> r.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
                .route("products", r -> r.path("/products/**").uri("lb://INVENTORY-SERVICE"))
                .build();
    }

    @Bean
    DiscoveryClientRouteDefinitionLocator locator(
            ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp){
        return new DiscoveryClientRouteDefinitionLocator(rdc,dlp);
    }
}
