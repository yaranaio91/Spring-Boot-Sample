package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;

@Configuration 
public class ThymeleafConfig {

	@Bean
	public ServletContextTemplateResolver templateResolver() {
		ServletContextTemplateResolver result = new ServletContextTemplateResolver();
		result.setPrefix("/WEB-INF/views/");
		result.setSuffix(".html");
		result.setTemplateMode("HTML5");
		result.setCharacterEncoding("UTF-8");
		result.setCacheable(false);
		return result;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine result = new SpringTemplateEngine();
		result.setTemplateResolver(templateResolver());
		return result;
	}

	@Bean
	public ThymeleafViewResolver thymeleafViewResolver() {

		ThymeleafViewResolver result = new ThymeleafViewResolver();

		result.setTemplateEngine(templateEngine());
		result.setOrder(1);
		result.setCharacterEncoding("UTF-8");
		return result;
	}
	
}