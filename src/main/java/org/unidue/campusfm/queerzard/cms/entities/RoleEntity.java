package org.unidue.campusfm.queerzard.cms.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class RoleEntity {

    @Id
    @GeneratedValue
    private long id;

    private String name;
    @ManyToMany(mappedBy = "roles")
    private List<UserEntity> users;



}
