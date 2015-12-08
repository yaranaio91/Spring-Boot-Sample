package sample.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;

@Configuration
public class BeanValidationConfig {

	@Bean
	public LocalValidatorFactoryBean validator() {

		LocalValidatorFactoryBean result = new LocalValidatorFactoryBean();
		result.setValidationMessageSource(messageSource());
		return result;
	}

	/**
	 * 独自プロパティファイルにしつつ、{0}などをラベルに置き換えさせる指定
	 */
	@Bean
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource result = new ReloadableResourceBundleMessageSource();
		result.setBasename("ValidationMessages");
		return result;
	}

}
