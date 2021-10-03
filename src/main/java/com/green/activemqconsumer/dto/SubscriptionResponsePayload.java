package com.green.activemqconsumer.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author green
 * @version 1.0
 * @project 03/10/2021 15:41
 */
@Data
@AllArgsConstructor
public class SubscriptionResponsePayload {

  private String url;
  private String topic;
}
