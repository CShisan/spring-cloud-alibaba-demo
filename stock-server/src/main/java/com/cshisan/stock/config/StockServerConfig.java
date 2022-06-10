package com.cshisan.stock.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuanbai
 * @date 2022/6/7 14:09
 */
@Data
@Configuration
@ConfigurationProperties(prefix = "info")
public class StockServerConfig {
    private String username;
}
