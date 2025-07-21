package com.emranhss.project.service;


import com.emranhss.project.entity.User;
import com.emranhss.project.repository.IUserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private IUserRepo userRepo;

public void saveOrUpdate(User user){
    userRepo.save(user);

}

public List<User>findAll(){
    return userRepo.findAll();
}


public User findById(int id){
    return userRepo.findById(id).get();
}

public void delete(User user){
    userRepo.delete(user);
}
}
