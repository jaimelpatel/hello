package com.ltlogic.db.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;

import com.ltlogic.db.superentity.SuperEntity;

@Entity
public class User extends SuperEntity{

	private String firstName;
	private String lastName;
	
	@ManyToMany(cascade=CascadeType.ALL)  
    @JoinTable(name="user_and_team", joinColumns={@JoinColumn(name="teamPk")}, 
    inverseJoinColumns={@JoinColumn(name="userPk")})  
	private Set<Team> teams = new HashSet<Team>(0);
	
	
	
}
