package com.cloubee.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cloubee.Model.PurchaseRequest;
import com.cloubee.Model.Receipt;
import com.cloubee.Model.User;
import com.cloubee.service.TrainTicketService;

@RestController
@RequestMapping("/api/tickets")
public class TrainTicketController {
    private final TrainTicketService trainTicketService;

    @Autowired
    public TrainTicketController(TrainTicketService trainTicketService) {
        this.trainTicketService = trainTicketService;
    }

    @PostMapping("/purchase")
    public Receipt purchaseTicket(@RequestBody PurchaseRequest request) {
        return trainTicketService.purchaseTicket(request.getFrom(), request.getTo(), request.getUserName(), request.getEmail(), request.getPricePaid());
    }

    @GetMapping("/users")
    public List<User> viewUsers() {
        return trainTicketService.viewUsers();
    }

    @DeleteMapping("/remove/{userName}")
    public void removeUser(@PathVariable String userName) {
        trainTicketService.removeUser(userName);
    }

    @PutMapping("/modifySeat/{userName}/{newSeat}")
    public void modifySeat(@PathVariable String userName, @PathVariable int newSeat) {
        trainTicketService.modifySeat(userName, newSeat);
    }
}
	