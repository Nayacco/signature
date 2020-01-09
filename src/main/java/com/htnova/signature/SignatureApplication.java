package com.htnova.signature;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

/**
 * 签名机制demo项目
 * 测试方法在 SignatureApplicationTests
 */
@SpringBootApplication
@ServletComponentScan
public class SignatureApplication {

	public static void main(String[] args) {
		SpringApplication.run(SignatureApplication.class, args);
	}

}
