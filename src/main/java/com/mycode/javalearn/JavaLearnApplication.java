package com.mycode.javalearn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.time.ZoneId;
import java.util.TimeZone;

/**
 * @author dengxin
 */
@SpringBootApplication
@MapperScan("com.mycode.javalearn.dao")
public class JavaLearnApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaLearnApplication.class, args);
	}

	/**
	 * 服务启动执行一次
	 */
	@PostConstruct
	void started(){
		// set system timezone cst
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}

}
