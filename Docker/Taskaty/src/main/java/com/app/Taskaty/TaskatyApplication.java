package com.app.Taskaty;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
@SpringBootApplication
@EnableAspectJAutoProxy
public class TaskatyApplication {
	public static void main(String[] args) {
		SpringApplication.run(TaskatyApplication.class, args);
	}
}