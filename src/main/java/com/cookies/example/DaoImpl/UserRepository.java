package com.cookies.example.DaoImpl;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cookies.example.model.User;

public interface UserRepository  extends JpaRepository<User, Integer>{

}
