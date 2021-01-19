package com.mnb.ThymeleafeMailTemplate;

import com.mnb.ThymeleafeMailTemplate.dto.MailRequest;
import com.mnb.ThymeleafeMailTemplate.dto.MailResponse;
import com.mnb.ThymeleafeMailTemplate.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
public class ThymeleafEMailTemplateApplication {
	@Autowired
	private EmailService service;

	@PostMapping("/sendingEmail")
public MailResponse sendEmail(@RequestBody MailRequest request){
	Map<String,Object> model=new HashMap<>();
	model.put("Name", request.getName());
	model.put("location", "Antalya,Turkey");
	return service.sendEmail(request, model);
}

	public static void main(String[] args) {
		SpringApplication.run(ThymeleafEMailTemplateApplication.class, args);
	}

}
