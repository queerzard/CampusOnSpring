package org.unidue.campusfm.queerzard.cms.database.dao;

import lombok.Getter;

import javax.persistence.Entity;

@Entity
public class Role extends AbstractEntity {


    @Getter private String name;

    public Role(){}
    public Role(String name){this.name = name;}



}
