package com.oasis.employeeconsumer.controllers;

import com.oasis.employeeconsumer.models.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;


@RestController
@RequestMapping("/rest")
public class ConsumerControllerClient {

	@Autowired
	RestTemplate restTemplate;
	
	
	@GetMapping("/employee/{username}")
	public ResponseEntity<Employee> getEmployee(@PathVariable ("username") String username) throws RestClientException, IOException{

		String baseUrl = "http://employee-producer/employee/" + username;

//		ResponseEntity<String> response = null;
//		try {
//			response = restTemplate.exchange(baseUrl, HttpMethod.GET, getHeaders(), String.class);
//		}
//		catch(Exception ex)
//		{
//			System.out.println(ex);
//		}
//
//		System.out.println(response.getBody());

		Employee employee = restTemplate.getForObject(baseUrl, Employee.class);

		return new ResponseEntity<>(employee, HttpStatus.ACCEPTED);
	}

//	private static HttpEntity<?> getHeaders() throws IOException{
//		HttpHeaders headers = new HttpHeaders();
//		headers.set("Accept", MediaType.APPLICATION_JSON_VALUE);
//		return new HttpEntity<>(headers);
//	}


	@GetMapping("/employees")
	public ResponseEntity<List<Employee>> all() throws RestClientException, IOException
		{
			String baseUrl = "http://employee-producer/employee/employees";

			ResponseEntity<List<Employee>> responseEntity =
					restTemplate.exchange(baseUrl, HttpMethod.GET, null,
					new ParameterizedTypeReference<List<Employee>>(){});

			List<Employee> employees = responseEntity.getBody();

			return new ResponseEntity<>(employees, HttpStatus.ACCEPTED);
		}



}
