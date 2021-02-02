package com.mycode.javalearn.cmd;

import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author nova
 */
@Component
@Order(51)
public class BeanCmdLineRunner implements CommandLineRunner {

	@Override
	public void run(String... args) throws Exception {
		System.out.println("bean init start");
		Thread.sleep(1000);
		System.out.println("bean init end");
	}
}
