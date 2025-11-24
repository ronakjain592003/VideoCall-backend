package com.alibou.vediocall;

import com.alibou.vediocall.user.User;
import com.alibou.vediocall.user.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class VediocallApplication {

	public static void main(String[] args) {
		SpringApplication.run(VediocallApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(UserService userService){
		return args->{
			userService.register(
					User.builder()
							.username("ali")
							.email("ali@gmail.com")
							.password("aaa")
							.build()
			);
			userService.register(
					User.builder()
							.username("john")
							.email("john@gmail.com")
							.password("aaa")
							.build()
			);
			userService.register(
					User.builder()
							.username("james")
							.email("james@gmail.com")
							.password("aaa")
							.build()
			);
		};

	}

}
