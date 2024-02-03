package com.cloubee.service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cloubee.Model.Receipt;
import com.cloubee.Model.User;
import com.cloubee.Repo.UserRepository;

@Service
public class TrainTicketService {
	private final UserRepository userRepository;

	@Autowired
	public TrainTicketService(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public Receipt purchaseTicket(String from, String to, String userName, String email, int pricePaid) {
		int seat = allocateSeat();
		User user = new User(userName, seat, (seat <= 10) ? "A" : "B");
		userRepository.save(user);
		return new Receipt(from, to, userName, email, pricePaid, seat);
	}

	public List<User> viewUsers() {
		return userRepository.findAll();
	}

	public void removeUser(String userName) {
		userRepository.delete(userName);
	}

	public void modifySeat(String userName, int newSeat) {
		userRepository.updateSeat(userName, newSeat);
	}

	private int allocateSeat() {
		List<User> users = userRepository.findAll();

		// Initialize sets for sections A and B
		Set<Integer> seatsSectionA = IntStream.rangeClosed(1, 10).boxed().collect(Collectors.toSet());
		Set<Integer> seatsSectionB = IntStream.rangeClosed(11, 20).boxed().collect(Collectors.toSet());

		// Remove seats already allocated
		users.forEach(user -> {
			if (user.getSection().equals("A")) {
				seatsSectionA.remove(user.getSeat());
			} else {
				seatsSectionB.remove(user.getSeat());
			}
		});

		// Choose a seat from the available ones
		int seat;
		if (!seatsSectionA.isEmpty()) {
			seat = seatsSectionA.iterator().next();
		} else if (!seatsSectionB.isEmpty()) {
			seat = seatsSectionB.iterator().next();
		} else {
			throw new RuntimeException("No available seats");
		}

		return seat;
	}

}
