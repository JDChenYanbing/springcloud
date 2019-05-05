package com.jk;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableConfigServer //注解开启配置服务器的功能
@EnableEurekaClient
@EnableDiscoveryClient
@RefreshScope
public class SpringcloudConfigServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringcloudConfigServerApplication.class, args);
	}

}
