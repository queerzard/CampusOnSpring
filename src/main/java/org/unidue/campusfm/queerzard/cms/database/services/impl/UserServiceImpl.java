package org.unidue.campusfm.queerzard.cms.database.services.impl;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;
import org.unidue.campusfm.queerzard.cms.database.repositories.UserRepository;
import org.unidue.campusfm.queerzard.cms.database.services.interfaces.UserService;

import javax.persistence.EntityManager;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private EntityManager entityManager;

    @Autowired
    @Getter private UserRepository userRepository;

    @Autowired private PasswordEncoder passwordEncoder;

    @Override
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @Override
    public UserEntity update(UserEntity userEntity) {
        return userRepository.saveAndFlush(userEntity);
    }

    @Override
    public UserEntity addUser(UserEntity user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    @Override
    public UserEntity addUserIfNotExists(UserEntity user) {
        return (userRepository.existsUserEntityByUserId(user.getUserId()) ? null : addUser(user));
    }

    @Override
    public boolean userExists(Long id) {return userRepository.existsUserEntityById(id);}

    @Override
    public boolean userExistsByEmail(String email) {return userRepository.existsUserEntityByEmail(email);}

    @Override
    public boolean userExistsByName(String username) {return userRepository.existsUserEntityByUsername(username);}

    @Override
    public boolean userExistsByUserId(String userId) {return userRepository.existsUserEntityByUserId(userId);}

    @Override
    public void delete(UserEntity entity) {
        userRepository.delete(entity);
    }

    @Override
    public UserEntity getUserById(String userId) {
        return userRepository.findUserEntityByUserId(userId);
    }

    @Override
    public UserEntity getUserByUsername(String username) {
        return userRepository.findUserEntityByUsername(username);
    }

    @Override
    public UserEntity getUserByEmail(String emailAddress) {
        return userRepository.findUserEntityByEmail(emailAddress);
    }

    @Override
    public List<UserEntity> getUsersByFirstName(String name) {
        return userRepository.findUserEntitiesByFirstName(name);
    }

    @Override
    public List<UserEntity> getUsersByLastName(String name) {
        return userRepository.findUserEntitiesByLastName(name);
    }

    @Override
    public long count() {
        return userRepository.count();
    }
}
