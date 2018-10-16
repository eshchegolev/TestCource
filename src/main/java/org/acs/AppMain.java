package org.acs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author GenCloud
 * @date 10/2018
 */
@SpringBootApplication(scanBasePackages = "org.acs")
public class AppMain {
	public static void main(String[] args) {
		SpringApplication.run(AppMain.class, args);
	}
}
