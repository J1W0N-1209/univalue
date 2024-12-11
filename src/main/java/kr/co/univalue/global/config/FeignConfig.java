package kr.co.univalue.global.config;

import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Configuration;

@Configuration
@EnableFeignClients(basePackages = "kr.co.univalue.global.feign")
public class FeignConfig {
}
