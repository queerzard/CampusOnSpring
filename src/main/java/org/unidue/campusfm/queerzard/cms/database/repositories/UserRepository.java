
/*
 * Copyright (c) 2023. Ozan A. Aslan (github/@queerzard)
 * All rights reserved.
 */

package org.unidue.campusfm.queerzard.cms.database.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.unidue.campusfm.queerzard.cms.database.dao.UserEntity;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {
    UserEntity findUserEntityByUsername(String username);
    UserEntity findUserEntityByEmail(String email);
    UserEntity findUserEntityById(String userId);
    boolean existsUserEntityByUsername(String name);
    boolean existsUserEntityByEmail(String email);
    boolean existsUserEntityById(String id);
    List<UserEntity> findUserEntitiesByFirstName(String firstName);
    List<UserEntity> findUserEntitiesByLastName(String firstName);
    List<UserEntity> findAllByEnabledIsTrue();

}
