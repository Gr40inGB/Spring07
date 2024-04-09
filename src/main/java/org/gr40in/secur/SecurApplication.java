package org.gr40in.secur;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableAspectJAutoProxy
@SpringBootApplication
public class SecurApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurApplication.class, args);

	}

}
