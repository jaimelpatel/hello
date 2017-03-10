package com.ltlogic.db.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.ManyToMany;

import com.ltlogic.db.superentity.SuperEntity;

public class Team extends SuperEntity {
	
	private String name;
	
	@ManyToMany(cascade=CascadeType.ALL, mappedBy="teams") 
	private Set<User> users = new HashSet<User>(0);
	

}
