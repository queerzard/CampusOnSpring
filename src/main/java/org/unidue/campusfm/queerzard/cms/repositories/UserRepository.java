package org.unidue.campusfm.queerzard.cms.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.unidue.campusfm.queerzard.cms.entities.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
