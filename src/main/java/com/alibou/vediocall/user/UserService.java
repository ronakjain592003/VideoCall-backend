package com.alibou.vediocall.user;

import com.sun.source.tree.BreakTree;
import lombok.Builder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Service
@Builder
public class UserService {
    private final List<User> userList = new ArrayList<>();

    public void register(User user){
        user.setStatus("online");
        userList.add(user);
    }

    public User login(User user){
        var userIndex = IntStream.range(0, userList.size())
                .filter(i -> userList.get(i).getEmail().equals(user.getEmail()))
                .findAny()
                .orElseThrow(()-> new RuntimeException("user not found"));

        var cUser = userList.get(userIndex);
        if(!user.getPassword().equals(cUser.getPassword()))
            throw new RuntimeException("password is incorrect");

        cUser.setStatus("online");

        return cUser;
    }

    public void logout(String email){
        var userIndex = IntStream.range(0, userList.size())
                .filter(i -> userList.get(i).getEmail().equals(email))
                .findAny()
                .orElseThrow(()-> new RuntimeException("user not found"));

        userList.get(userIndex).setStatus("offline");
    }

    public List<User> findAll(){
        return userList;
    }

}
