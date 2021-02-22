package com.hawklawfirm.email_signature_tool;

import com.hawklawfirm.email_signature_tool.storage.StorageProperties;
import com.hawklawfirm.email_signature_tool.storage.StorageService;
import com.hawklawfirm.email_signature_tool.email.EmailSender;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.awt.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

@SpringBootApplication
@EnableConfigurationProperties(StorageProperties.class)
public class EmailSignatureToolApplication {
	EmailSender sender;
	Runtime runtime = Runtime.getRuntime();

	EmailSignatureToolApplication(EmailSender sender){
		this.sender = sender;
//		sender.send("michael.williams705@live.com",email("Michael","Prinz","System Administrator"), "HawkLaw Email Signature");

	}

	public static void main(String[] args) {
		SpringApplication.run(EmailSignatureToolApplication.class, args);

	}

	@Bean
	CommandLineRunner init(StorageService storageService) {
		return (args) -> {
			storageService.deleteAll();
			storageService.init();
		};
	}


}
