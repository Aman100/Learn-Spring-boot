package com.example.SpringSecutiryLearning.repository;

import com.example.SpringSecutiryLearning.pojo.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<User,Integer>{
}
