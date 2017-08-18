package com.permission;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.github.pagehelper.autoconfigure.PageHelperAutoConfiguration;

@SpringBootApplication(scanBasePackages = "com.permission")
@EnableTransactionManagement
@MapperScan("com.permission.mapper")
@AutoConfigureBefore(PageHelperAutoConfiguration.class)
public class SecurityApp {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApp.class, args);
	}
	
}
