package kr.co.ensmart.frameworkdemo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "kr.co.ensmart.frameworkdemo.app.dao")
public class FrameworkDemoMybatisApplication {

	public static void main(String[] args) {
		SpringApplication.run(FrameworkDemoMybatisApplication.class, args);
	}

}
