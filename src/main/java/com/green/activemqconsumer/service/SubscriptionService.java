package com.green.activemqconsumer.service;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.jms.*;

/**
 * @author green
 * @version 1.0
 * @project 03/10/2021 15:15
 */
@Service
public class SubscriptionService {

  @Value("${spring.activemq.broker-url}")
  private String brokerUrl;

  @Value("${spring.activemq.user}")
  private String username;

  @Value("${spring.activemq.password}")
  private String password;

  public void subscribe(String newTopic, String subscriber) {
    ConnectionFactory factory = new ActiveMQConnectionFactory(
      username, password, brokerUrl
    );

    Connection connection;
    try {
      String clientId = String.valueOf(System.currentTimeMillis());
      connection = factory.createConnection();
      connection.setClientID(clientId);
      connection.start();
      Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);

      // Create Topic if not Existing
      Topic topic = session.createTopic(newTopic);

      // create subscriber for topic
      MessageConsumer consumer = session.createDurableSubscriber(topic, clientId);

      // listens for messages sent by publisher
      consumer.setMessageListener(message -> {
        try {
          System.out.println(((TextMessage) message).getText());
          System.out.println(subscriber);
        } catch (JMSException e) {
          e.printStackTrace();
        }
      });


    } catch (JMSException e) {
      e.printStackTrace();
    }
  }
}
