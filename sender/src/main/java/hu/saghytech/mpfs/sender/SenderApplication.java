package hu.saghytech.mpfs.sender;

import hu.saghytech.mpfs.sender.service.MultipartSenderService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class SenderApplication {

	public static void main(String[] args) {

		ConfigurableApplicationContext context = SpringApplication.run(SenderApplication.class, args);
		MultipartSenderService service = context.getBean(MultipartSenderService.class);
		service.sendMultipartMessage();
	}

}
