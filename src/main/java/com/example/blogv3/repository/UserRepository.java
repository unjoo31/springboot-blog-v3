package com.example.blogv3.repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.blogv3.dto.JoinDTO;
import com.example.blogv3.dto.LoginDTO;

@Repository
public class UserRepository {
    
    @Autowired
    private EntityManager em;

    @Transactional
    public void save(JoinDTO joinDTO){
        Query query = em.createNativeQuery("insert into user_tb(username, password, email) values(:username, :password, :email)");
        query.setParameter("username", joinDTO.getUsername());
        query.setParameter("password", joinDTO.getPassword());
        query.setParameter("email", joinDTO.getEmail());
        query.executeUpdate();
    }

    public void select(LoginDTO loginDTO){
        Query query = em.createNativeQuery("select * from user_tb where username = :username AND password = :password");
        query.setParameter("username", loginDTO.getUsername());
        query.setParameter("password", loginDTO.getPassword());
        query.getSingleResult();
    }
}
