package com.intentsg.service.user.controller;

import com.intentsg.model.TicketDto;
import com.intentsg.model.UserDto;
import com.intentsg.service.user.entity.User;
import com.intentsg.service.user.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.List;


@Controller
@RequestMapping("/users")
public class UserController {
	final
	private UserRepository userRepository;

	final
	private DiscoveryClient discoveryClient;

	final
	private RestTemplate restTemplate;

	@Autowired
	public UserController(UserRepository userRepository, DiscoveryClient discoveryClient, RestTemplate restTemplate) {
		this.userRepository = userRepository;
		this.discoveryClient = discoveryClient;
		this.restTemplate = restTemplate;
	}


	private ServiceInstance getServiceInstance(){
		return discoveryClient.getInstances("edge-service").get(0);
	}

	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("users test");
	}

	@GetMapping("/{id}")
	public ResponseEntity <UserDto> getUser (@PathVariable long id){
		User user = userRepository.findById(id).orElseThrow(RuntimeException::new);
		UserDto userDto = UserDto.builder()
				.id(user.getId())
				.firstName(user.getFirstName())
				.lastName(user.getLastName())
				.build();
		return  new ResponseEntity<>(userDto, HttpStatus.OK);
	}

	@GetMapping("/tickets/{id}")
	public  ResponseEntity <List> getUserByTicketId (@PathVariable Long id){
		return restTemplate.getForEntity(getServiceInstance().getUri().toString()+"api/tickets/owner/"+id,
				List.class);
	}
}
