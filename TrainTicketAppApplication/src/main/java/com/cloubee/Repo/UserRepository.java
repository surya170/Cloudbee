package com.cloubee.Repo;

import java.util.List;

import com.cloubee.Model.User;

public interface UserRepository {
    List<User> findAll();
    void save(User user);
    void delete(String userName);
    void updateSeat(String userName, int newSeat);
}
