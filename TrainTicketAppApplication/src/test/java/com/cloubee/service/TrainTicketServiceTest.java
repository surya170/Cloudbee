package com.cloubee.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import com.cloubee.Model.PurchaseRequest;
import com.cloubee.Model.Receipt;
import com.cloubee.Model.User;
import com.cloubee.Repo.UserRepository;

@ExtendWith(MockitoExtension.class)
class TrainTicketServiceTest {

    @Mock
    private UserRepository userRepository;

    @InjectMocks
    private TrainTicketService trainTicketService;

    @Test
    void purchaseTicket_AllocateSeat_Success() {
        // ... (setup and mock userRepository)

    	 // Create a PurchaseRequest object
        PurchaseRequest request = new PurchaseRequest();
        request.setFrom("London");
        request.setTo("France");
        request.setUserName("John Doe");
        request.setEmail("john.doe@example.com");
        request.setPricePaid(20);
        
        // Performing the purchase
        Receipt receipt = trainTicketService.purchaseTicket(request.getFrom(), request.getTo(),
                request.getUserName(), request.getEmail(), request.getPricePaid());

        // Print actual values
        System.out.println("Actual Seat: " + receipt.getSeat());
        System.out.println("Actual Section: " + receipt.getSection());

        // Verifying that userRepository's save method is called
        verify(userRepository, times(1)).save(any(User.class));

        // Verifying that the seat is within the expected range
        assertTrue(receipt.getSeat() >= 1 && receipt.getSeat() <= 20);

        // Verifying that the section is correct
        assertEquals((receipt.getSeat() <= 10) ? "A" : "B", receipt.getSection());
    }
    
    @Test
    void viewUsers_ReturnsUsersList() {
        // Mocking the userRepository to return a list of users
        when(userRepository.findAll()).thenReturn(Arrays.asList(
                new User("User1", 5, "A"),
                new User("User2", 15, "B")
        ));

        // Performing the viewUsers operation
        List<User> users = trainTicketService.viewUsers();

        // Verifying that userRepository's findAll method is called
        verify(userRepository, times(1)).findAll();

        // Verifying that the returned list is not null and contains the expected number of users
        assertNotNull(users);
        assertEquals(2, users.size());
    }

    @Test
    void removeUser_RemovesUser_Success() {
        // Mocking the userRepository
        doNothing().when(userRepository).delete("John Doe");

        // Performing the removeUser operation
        trainTicketService.removeUser("John Doe");

        // Verifying that userRepository's delete method is called
        verify(userRepository, times(1)).delete("John Doe");
    }

    @Test
    void modifySeat_ModifiesSeat_Success() {
        // Mocking the userRepository
        doNothing().when(userRepository).updateSeat("John Doe", 10);

        // Performing the modifySeat operation
        trainTicketService.modifySeat("John Doe", 10);

        // Verifying that userRepository's updateSeat method is called
        verify(userRepository, times(1)).updateSeat("John Doe", 10);
    }

}
