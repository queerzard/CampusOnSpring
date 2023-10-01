package org.unidue.campusfm.queerzard.cms.database.dao;

import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class RoleEntity extends AbstractEntity{

    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;



}
