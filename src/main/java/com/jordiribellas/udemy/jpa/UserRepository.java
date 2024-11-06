package com.jordiribellas.udemy.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import com.jordiribellas.udemy.user.User;

public interface UserRepository extends JpaRepository<User, Integer>{

}
