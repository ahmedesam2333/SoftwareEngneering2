package com.TaskMicroservice;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@EnableDiscoveryClient
@SpringBootApplication
@EnableAspectJAutoProxy
public class TaskMicroserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(TaskMicroserviceApplication.class, args);
	}

}
