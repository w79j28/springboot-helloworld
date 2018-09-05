package com.test.main;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
public class Application {
	@RequestMapping("/")
	public String home() {
		System.out.println("测试");
		String env_testurl = System.getenv("TEST_URL");
		InetAddress addr;
		String ip = "";
		String hostName = "";
		try {
			addr = InetAddress.getLocalHost();
			ip = addr.getHostAddress().toString(); // 获取本机ip
			hostName = addr.getHostName().toString(); // 获取本机计算机名称
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		return String.format("V3-->Hello Spring Boot!(env[TEST_URL]:%s) ip=%s, hostname=%s", env_testurl, ip, hostName);
	}

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
