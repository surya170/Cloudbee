package com.cloubee.Repo;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.cloubee.Model.User;


@Repository
public class UserRepositoryImpl implements UserRepository {
    private List<User> users = new ArrayList<>();

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users);
    }

    @Override
    public void save(User user) {
        users.add(user);
    }

    @Override
    public void delete(String userName) {
        users.removeIf(user -> user.getName().equals(userName));
    }

    @Override
    public void updateSeat(String userName, int newSeat) {
        for (User user : users) {
            if (user.getName().equals(userName)) {
                user.setSeat(newSeat);
                user.setSection((newSeat <= 10) ? "A" : "B");
                break;
            }
        }
    }
}
