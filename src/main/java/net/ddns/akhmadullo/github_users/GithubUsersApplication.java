package net.ddns.akhmadullo.github_users;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})public class GithubUsersApplication {
	public static void main(String[] args) {
		SpringApplication.run(GithubUsersApplication.class, args);
	}

}
