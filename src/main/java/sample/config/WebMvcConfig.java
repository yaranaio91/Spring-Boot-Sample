package sample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class WebMvcConfig extends WebMvcConfigurerAdapter {

	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/css/**").addResourceLocations(
				"/WEB-INF/css/");
		registry.addResourceHandler("/img/**").addResourceLocations(
				"/WEB-INF/img/");
		registry.addResourceHandler("/js/**").addResourceLocations(
				"/WEB-INF/js/");
	}

	// equivalent for <mvc:default-servlet-handler/> tag
	// @Override
	// public void
	// configureDefaultServletHandling(DefaultServletHandlerConfigurer
	// configurer) {
	// configurer.enable();
	// }

}
