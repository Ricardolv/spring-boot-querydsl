package com.richard.springbootquerydsl.repository.queydsl.impl;

import com.querydsl.jpa.impl.JPAQuery;
import com.richard.springbootquerydsl.model.QUser;
import com.richard.springbootquerydsl.model.User;
import com.richard.springbootquerydsl.repository.queydsl.UserRepositoryQueryDsl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public class UserRepositoryQueryDslImpl implements UserRepositoryQueryDsl {

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public List<User> findUserByUsernameAndEmail(String username, String email) {
        QUser qUser = QUser.user;
        JPAQuery query = (JPAQuery) new JPAQuery(entityManager).from(qUser);

        if(username != null && !username.isEmpty()){
            query.where(qUser.username.containsIgnoreCase(username));
        }

        if(email != null && !email.isEmpty()){
            query.where(qUser.email.containsIgnoreCase(email));
        }

        return query.fetch();
    }

    @Override
    public User findByEmail(String email) {
        QUser qUser = QUser.user;
        JPAQuery query = (JPAQuery) new JPAQuery(entityManager).from(qUser);

        if(email != null && !email.isEmpty()){
            query.where(qUser.email.containsIgnoreCase(email));
        }


        List<User> users = query.fetch();

        //TODO necessario fazer tratamento
        return users.get(0);
    }

}
