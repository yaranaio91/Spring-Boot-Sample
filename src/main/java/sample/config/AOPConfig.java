package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import sample.aop.LogInterceptor;

@Configuration
@EnableAspectJAutoProxy
public class AOPConfig {

	@Bean
	public LogInterceptor log() {
		LogInterceptor result = new LogInterceptor();
		return result;
	}

}
