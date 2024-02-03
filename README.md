# Train Ticket Management System

## High-Level Overview:

The Train Ticket Management System is a simple Spring Boot application designed to manage train tickets. It adheres to the MVC (Model-View-Controller) architecture and employs a layered structure, including a service layer (`TrainTicketService`), a repository layer (`UserRepository`), and a controller layer (`TrainTicketController`).

## Code Components:

### 1. Model Classes:
- **User:** Represents a user with attributes `name`, `seat`, and `section`.
- **Receipt:** Represents a receipt with details such as `from`, `to`, `user`, `email`, `pricePaid`, and `seat`.

### 2. Repository Interface:
- **UserRepository:** An interface defining methods for managing user data, including `findAll`, `save`, `delete`, and `updateSeat`.

### 3. Repository Implementation:
- **UserRepositoryImpl:** An implementation of the `UserRepository` interface. It utilizes an in-memory list (`users`) to store user data.

### 4. Service Layer:
- **TrainTicketService:** Manages business logic related to train ticket operations. It interacts with the `UserRepository` to perform operations such as purchasing a ticket, viewing users, removing a user, and modifying a user's seat. It also includes a method `allocateSeat` to determine an available seat.

### 5. Controller:
- **TrainTicketController:** A Spring MVC controller that exposes RESTful APIs for ticket operations. It uses the `TrainTicketService` to handle requests.

### 6. Main Application Class:
- **TrainTicketAppApplication:** The main class that starts the Spring Boot application.

## Interactions:

1. **User Makes a Purchase (API Endpoint: /api/tickets/purchase):**
   - The user sends a purchase request to the `purchaseTicket` API of `TrainTicketController`.
   - The controller delegates the request to the `purchaseTicket` method in `TrainTicketService`.
   - The service allocates a seat, creates a `User` object, saves it using the `UserRepository`, and returns a `Receipt`.

2. **Viewing Users (API Endpoint: /api/tickets/users):**
   - The user sends a request to the `viewUsers` API of `TrainTicketController`.
   - The controller delegates the request to the `viewUsers` method in `TrainTicketService`.
   - The service retrieves the list of users from the `UserRepository` and returns it.

3. **Removing a User (API Endpoint: /api/tickets/remove/{userName}):**
   - The user sends a request to the `removeUser` API of `TrainTicketController` with a specific username.
   - The controller delegates the request to the `removeUser` method in `TrainTicketService`.
   - The service removes the user with the given username using the `UserRepository`.

4. **Modifying a User's Seat (API Endpoint: /api/tickets/modifySeat/{userName}/{newSeat}):**
   - The user sends a request to the `modifySeat` API of `TrainTicketController` with a specific username and a new seat.
   - The controller delegates the request to the `modifySeat` method in `TrainTicketService`.
   - The service updates the user's seat using the `UserRepository`.

