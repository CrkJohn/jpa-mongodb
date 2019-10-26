package ieti.trello.backend.trello;

import ieti.trello.backend.trello.config.AppConfiguration;
import ieti.trello.backend.trello.config.JwtFilter;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

@SpringBootApplication
public class TrelloApplication implements CommandLineRunner {

	@Bean
	public FilterRegistrationBean jwtFilter(){
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter( new JwtFilter() );
		registrationBean.addUrlPatterns( "/v1/user/*" );
		registrationBean.addUrlPatterns( "/v1/task/*" );
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(TrelloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");

	}
