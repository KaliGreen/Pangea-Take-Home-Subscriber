package com.green.activemqconsumer;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@Slf4j
public class ActivemqConsumerApplication {

  public static void main(String[] args) {
    SpringApplication.run(ActivemqConsumerApplication.class, args);

  }

}
