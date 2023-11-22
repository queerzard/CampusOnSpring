
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.database.services.interfaces;

import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;

import java.util.List;

public interface UserService {

    List<UserEntity> findAll();

    List<UserEntity> findAllEnabled();

    UserEntity update(UserEntity userEntity);

    UserEntity addUser(UserEntity user);

    UserEntity addUserIfNotExists(UserEntity user);

    boolean userExists(String id);

    boolean userExistsByEmail(String email);
    boolean userExistsByName(String username);
    boolean userExistsByUserId(String userId);


    void delete(UserEntity entity);

    UserEntity getUserById(String userId);
    UserEntity getUserByUsername(String username);
    UserEntity getUserByEmail(String emailAddress);
    List<UserEntity> getUsersByFirstName(String name);
    List<UserEntity> getUsersByLastName(String name);

    long count();

}
