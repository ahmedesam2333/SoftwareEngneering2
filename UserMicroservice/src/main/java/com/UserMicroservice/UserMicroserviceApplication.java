package com.UserMicroservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
@EnableAspectJAutoProxy
public class UserMicroserviceApplication {
	public static void main(String[] args) {
		SpringApplication.run(UserMicroserviceApplication.class, args);
	}
}