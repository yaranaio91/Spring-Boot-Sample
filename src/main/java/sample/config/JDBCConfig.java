package sample.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

@Configuration
public class JDBCConfig {

	@Bean
	public BasicDataSource dataSource() {
		BasicDataSource result = new BasicDataSource();
		result.setDriverClassName("com.mysql.jdbc.Driver");
		result.setUrl("jdbc:mysql://localhost:3306/spring");
		result.setUsername("root");
		result.setPassword("passw0rd");
		return result;
	}

	@Bean
	public DataSourceTransactionManager transactionManager() {
		DataSourceTransactionManager result = new DataSourceTransactionManager();
		result.setDataSource(dataSource());
		return result;
	}
}