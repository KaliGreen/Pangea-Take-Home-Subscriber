package com.oasis.employeeconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class EmployeeConsumerApplication{

	public static void main(String[] args) {


		SpringApplication.run(EmployeeConsumerApplication.class, args);

//		 throws RestClientException, IOException
//		ApplicationContext ctx = SpringApplication.run(EmployeeConsumerApplication.class, args);
//		ConsumerControllerClient consumerControllerClient = ctx.getBean(ConsumerControllerClient.class);
//		System.out.println(consumerControllerClient);
//		consumerControllerClient.getEmployee();
	}
	
//	@Bean
//	public ConsumerControllerClient consumerControllerClient() {
//		return new ConsumerControllerClient();
//		}

}
