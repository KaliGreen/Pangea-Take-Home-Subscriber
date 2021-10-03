package com.green.activemqconsumer.controller;

import com.green.activemqconsumer.dto.SubscriptionRequestPayload;
import com.green.activemqconsumer.dto.SubscriptionResponsePayload;
import com.green.activemqconsumer.service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author green
 * @version 1.0
 * @project 03/10/2021 15:03
 */
@RestController
public class SubscriptionRestController {

  @Autowired
  private SubscriptionService subscriptionService;
  private final static String FIRST_SUBSCRIBER = "/subscribe/firstSubscriber/{topic}";
  private final static String SECOND_SUBSCRIBER = "/subscribe/secondSubscriber/{topic}";

  @PostMapping(FIRST_SUBSCRIBER)
  public ResponseEntity<?> firstSubscriberToTopic(@RequestBody SubscriptionRequestPayload requestPayload, @PathVariable String topic) {
    subscriptionService.subscribe(topic, "First Subscriber");
    return new ResponseEntity<>(new SubscriptionResponsePayload(requestPayload.getUrl(), topic), HttpStatus.OK);
  }


  @PostMapping(SECOND_SUBSCRIBER)
  public ResponseEntity<?> secondSubscribeToTopic(@RequestBody SubscriptionRequestPayload requestPayload, @PathVariable String topic) {
    subscriptionService.subscribe(topic, "Second Subscriber");
    return new ResponseEntity<>(new SubscriptionResponsePayload(requestPayload.getUrl(), topic), HttpStatus.OK);
  }
}
