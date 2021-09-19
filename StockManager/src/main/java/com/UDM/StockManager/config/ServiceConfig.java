package com.UDM.StockManager.config;

import com.UDM.StockManager.service.StockService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceConfig {


        @Bean
        public StockService getStockService(){
            return new StockService();
        }

}
