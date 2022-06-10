package com.cshisan.order.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

/**
 * @author yuanbai
 * @date 2022/6/7 14:09
 */
@Data
@RefreshScope
@Configuration
@ConfigurationProperties(prefix = "info")
public class OrderServerConfig {
    private String username;
    private String age;
}
