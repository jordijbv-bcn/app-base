package com.base.app.application.core.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name="user")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id 
	@GeneratedValue(strategy=IDENTITY)    
    @Column(name="id", unique=true, nullable=false)
	private int id;

    @Column(name="email", unique=true, nullable=false, length=100)
	private String email;

    
    @Column(name="first_name", length=100)
	private String firstName;

    
    @Column(name="last_name", length=100)
	private String lastName;
    
    @Column(name="phone", length=10)
	private int phone;
    
    @Column(name="birthdate")
	private Date birthdate;
    
    @Column(name="password", length=255)
	private String password;

	@ManyToMany(fetch=FetchType.LAZY)
    @JoinTable(name="user_role", joinColumns = { 
        @JoinColumn(name="user_id", referencedColumnName="id", nullable=false, updatable=false) }, inverseJoinColumns = { 
        @JoinColumn(name="role_id", referencedColumnName="id", nullable=false, updatable=false) })
	private List<Role> roles;

    public User(int id) {
		this.id = id;
    }
    
}
