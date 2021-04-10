package com.intentsg.service.ticket.controller;


import com.intentsg.model.TicketDto;
import com.intentsg.model.UserDto;
import com.intentsg.service.ticket.entity.Ticket;
import com.intentsg.service.ticket.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;


@Controller
@RequestMapping("/tickets")
public class TicketController {

    final
    private TicketRepository ticketRepository;

    final
    private DiscoveryClient discoveryClient;

    final
    private RestTemplate restTemplate;

    @Autowired
    public TicketController(TicketRepository ticketRepository, DiscoveryClient discoveryClient, RestTemplate restTemplate) {
        this.ticketRepository = ticketRepository;
        this.discoveryClient = discoveryClient;
        this.restTemplate = restTemplate;
    }

    private ServiceInstance getServiceInstance(){
        return discoveryClient.getInstances("edge-service").get(0);
    }

	@GetMapping("/test")
	public ResponseEntity test() {
		return ResponseEntity.ok("ticket-service");
	}

    @GetMapping("/user/{id}")
    public  ResponseEntity <UserDto> getUserByTicketId (@PathVariable Long id){
        Ticket ticket = ticketRepository.findById(id).get();
        return restTemplate.getForEntity(getServiceInstance().getUri().toString()+"api/users/"+ticket.getUserId(),
                UserDto.class);
    }

    @GetMapping("/owner/{id}")
    public  ResponseEntity <List<TicketDto>> getTicketsByOwnerId (@PathVariable Long id){
        List <TicketDto> tickets = ticketRepository.findAll()
                .stream()
                .filter(x->x.getUserId().equals(id))
                .sorted(Comparator.comparing(Ticket::getDate))
                .map(ticket -> TicketDto.
                        builder()
                        .ticketId(ticket.getId())
                        .date(ticket.getDate())
                        .hallNumber(ticket.getHallNumber())
                        .placeNumber(ticket.getPlaceNumber())
                        .userId(ticket.getUserId())
                        .build())
                .collect(Collectors.toList());
        return  new ResponseEntity<List<TicketDto>>(tickets, HttpStatus.OK);
    }


}
