package org.unidue.campusfm.queerzard.cms.services.impl;

import org.springframework.stereotype.Service;
import org.unidue.campusfm.queerzard.cms.entities.UserEntity;
import org.unidue.campusfm.queerzard.cms.services.interfaces.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserEntity> findAll() {
        return null;
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return null;
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        return null;
    }

    @Override
    public UserEntity addUserIfNotExists(UserEntity user) {
        return null;
    }

    @Override
    public boolean userExists(Long id) {
        return false;
    }

    @Override
    public void delete(UserEntity entity) {

    }

    @Override
    public UserEntity getUserById(String userId) {
        return null;
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return null;
    }

    @Override
    public UserEntity getUserByEmail(String emailAddress) {
        return null;
    }

    @Override
    public List<UserEntity> getUsersByFirstName(String name) {
        return null;
    }

    @Override
    public List<UserEntity> getUsersByLastName(String name) {
        return null;
    }

    @Override
    public long count() {
        return 0;
    }
}
