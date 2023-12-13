package com.debartolodiego.puntocaldaie.clienteservice.config;

import com.debartolodiego.caldaiaservice.client.CaldaiaClient;
import com.debartolodiego.puntocaldaie.clienteservice.ClienteClient;
import com.debartolodiego.stufaservice.client.StufaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class WebClientConfig {

    @Autowired
    private LoadBalancedExchangeFilterFunction loadBalancedExchangeFilterFunction;

    @Bean
    public WebClient stufaWebClient(){
        return WebClient.builder()
                .baseUrl("http://stufa-service")
                .filter(loadBalancedExchangeFilterFunction)
                .build();
    }

    @Bean
    public StufaClient stufaClient(){
        HttpServiceProxyFactory httpServiceProxyFactory=
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(stufaWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(StufaClient.class);
    }


    @Bean
    public WebClient caldaiaWebClient(){
        return WebClient.builder()
                .baseUrl("http://stufa-service")
                .filter(loadBalancedExchangeFilterFunction)
                .build();
    }

    @Bean
    public CaldaiaClient caldaiaClient(){
        HttpServiceProxyFactory httpServiceProxyFactory=
                HttpServiceProxyFactory.builder(WebClientAdapter.forClient(caldaiaWebClient()))
                        .build();
        return httpServiceProxyFactory.createClient(CaldaiaClient.class);
    }



}
