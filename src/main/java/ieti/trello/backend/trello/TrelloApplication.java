package ieti.trello.backend.trello;

import ieti.trello.backend.trello.config.AppConfiguration;
import ieti.trello.backend.trello.config.JwtFilter;
import ieti.trello.backend.trello.entities.Task;
import ieti.trello.backend.trello.entities.User;
import ieti.trello.backend.trello.services.ITaskService;
import ieti.trello.backend.trello.services.IUserService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoOperations;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

@SpringBootApplication
public class TrelloApplication implements CommandLineRunner {

	@Autowired
	@Qualifier("taskServiceMongo")
	ITaskService iTaskService;

	@Autowired
	@Qualifier("userServiceMongo")
	IUserService iUserService;

	@Bean
	public FilterRegistrationBean jwtFilter() {
		final FilterRegistrationBean registrationBean = new FilterRegistrationBean();
		registrationBean.setFilter(new JwtFilter());
		registrationBean.addUrlPatterns("/v1/user/*");
		registrationBean.addUrlPatterns("/v1/task/*");
		return registrationBean;
	}

	public static void main(String[] args) {
		SpringApplication.run(TrelloApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfiguration.class);
		MongoOperations mongoOperation = (MongoOperations) applicationContext.getBean("mongoTemplate");
		for(int i = 0 ; i < 25 ; i++){
			Task task = new Task();
			task.set_id(ObjectId.get());
			task.setName("test number " + String.valueOf(i+1));
			task.setResponsible("reponsible"+String.valueOf((int) (Math.random() * 10) + 1));
			task.setPriority((int) (Math.random() * 10) + 1);
			task.setExpirationDate(new Date());
			iTaskService.saveTasks(task);
		}
		for(int i = 0 ; i < 10 ; i++){
			User user = new User();
			user.set_id(ObjectId.get());
			user.setName("reponsible"+String.valueOf(i+1));
			user.setEmail("reponsible"+ String.valueOf(i+1)));
			user.setPassword(String.valueOf("12345"));
			iTaskService.saveTasks(task);
		}

	}
}