package springboot.practise.springbootdemo;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication //This annotation is known as a meta-annotation, it combines @SpringBootConfiguration, @EnableAutoConfiguration and @ComponentScan.
public class SpringBootDemoApplication {

	@RequestMapping("/")
	String home(){
		return "Hello World !";
	}

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(SpringBootDemoApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
